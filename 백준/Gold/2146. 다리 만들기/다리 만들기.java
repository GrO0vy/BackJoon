import java.io.*;
import java.util.*;

public class Main{
    static int answer = Integer.MAX_VALUE;
    static int N;
    static int[][] map;
    static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int landNum = 1;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && map[i][j] == 1) giveNumber(i, j, landNum++, visited);
            }
        }
        
        for(int i = 1; i < landNum; i++){
            makeBridge(i);
        }

        System.out.println(answer);
    }

    static void giveNumber(int x, int y, int landNum, boolean[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int curX = pos[0];
            int curY = pos[1];

            if(!visited[curX][curY]){
                visited[curX][curY] = true;
                map[curX][curY] = landNum;

                for(int[] delta: deltas){
                    int nextX = curX + delta[0];
                    int nextY = curY + delta[1];

                    if(inRange(nextX, nextY) && !visited[nextX][nextY] && map[nextX][nextY] == 1){
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }
    }

    static void makeBridge(int landNum){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == landNum) {
                    queue.offer(new int[]{i, j, 0});
                }
            }
        }

        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int curX =pos[0];
            int curY =pos[1];
            int dis =pos[2];

            for(int[] delta: deltas){
                int nextX = curX + delta[0];
                int nextY = curY + delta[1];

                if(!inRange(nextX, nextY)) continue;

                if(!visited[nextX][nextY] && map[nextX][nextY] == 0) {
                    queue.offer(new int[]{nextX, nextY, dis + 1});
                    visited[nextX][nextY] = true;
                }
                else{
                    if(map[nextX][nextY] != 0 && map[nextX][nextY] != landNum){
                        answer = Math.min(answer, dis);
                    }
                }
            }
        }
    }

    static boolean inRange(int x, int y){
        return -1 < x && x < N && -1 < y && y < N;
    }
}