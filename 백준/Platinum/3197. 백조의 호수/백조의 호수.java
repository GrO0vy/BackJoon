import java.util.*;
import java.io.*;

public class Main{
    static int R;
    static int C;
    static char[][] map;
    static boolean[][] swanVisit;
    static boolean[][] iceVisit;
    static Queue<int[]> swanQueue;
    static Queue<int[]> iceQueue;
    static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        swanQueue = new LinkedList<>();
        iceQueue = new LinkedList<>();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        swanVisit = new boolean[R][C];
        iceVisit = new boolean[R][C];

        int[] start = {};

        for(int i = 0; i < R; i++){
            String row = br.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = row.charAt(j);

                if(map[i][j] == 'L') {
                    start = new int[]{i, j};
                }
            }
        }

        initIce();

        swanQueue.offer(start);
        map[start[0]][start[1]] = '.';
        swanVisit[start[0]][start[1]] = true;

        int day = 0;
        while(!isPossible()){
            day++;
        }

        System.out.println(day);
    }

    static void initIce(){
        boolean[][] visited = new boolean[R][C];
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(map[i][j] != 'X' && !visited[i][j]) bfs(i, j, visited);
            }
        }
    }

    static void bfs(int x, int y, boolean[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] current = queue.poll();

            for(int[] delta: deltas){
                int nextX = current[0] + delta[0];
                int nextY = current[1] + delta[1];

                if(inRange(nextX, nextY) && !visited[nextX][nextY]){
                    visited[nextX][nextY] = true;

                    if(map[nextX][nextY] == 'X') {
                        iceQueue.offer(new int[]{nextX, nextY});
                        iceVisit[nextX][nextY] = true;
//                        System.out.printf("%d %d\n",nextX, nextY);
                    }
                    else {
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }
    }

    static boolean isPossible(){
        Queue<int[]> nextQueue = new LinkedList<>();

        while(!swanQueue.isEmpty()){
            int[] current = swanQueue.poll();

            if(map[current[0]][current[1]] == 'L') return true;

            for(int[] delta: deltas){
                int nextX = current[0] + delta[0];
                int nextY = current[1] + delta[1];

                if(!inRange(nextX, nextY) || swanVisit[nextX][nextY]) continue;

                swanVisit[nextX][nextY] = true;

                if(map[nextX][nextY] != 'X'){
                    swanQueue.offer(new int[]{nextX, nextY});
                }
                else {
                    nextQueue.offer(new int[]{nextX, nextY});
//                    System.out.printf("%d %d\n", nextX, nextY);
                }
            }
        }

        swanQueue = new LinkedList<>(nextQueue);

        melt();

        return false;
    }

    static void melt(){
        int size = iceQueue.size();

        for(int i = 0; i < size; i++){
            int[] melted = iceQueue.poll();

            map[melted[0]][melted[1]] = '.';

            for(int[] delta: deltas){
                int nextX = melted[0] + delta[0];
                int nextY = melted[1] + delta[1];

                if(inRange(nextX, nextY) && map[nextX][nextY] == 'X' && !iceVisit[nextX][nextY]){
//                    System.out.printf("%d %d\n", nextX, nextY);
                    iceVisit[nextX][nextY] = true;
                    iceQueue.offer(new int[]{nextX, nextY});
                }
            }
        }
    }

    static boolean inRange(int x, int y){
        return -1 < x && x < R && -1 < y && y < C;
    }
}