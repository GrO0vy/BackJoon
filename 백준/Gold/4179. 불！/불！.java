import java.io.*;
import java.util.*;

public class Main{
    static int R;
    static int C;
    static char[][] map;
    static int[][] fireTime;
    static Queue<int[]> nodes;
    static Queue<int[]> fire;
    static int result = Integer.MAX_VALUE;
    static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        fireTime = new int[R][C];

        nodes = new LinkedList<>();
        fire = new LinkedList<>();

        for(int i = 0; i < R; i++) map[i] = br.readLine().toCharArray();
        for(int i = 0; i < R; i++) Arrays.fill(fireTime[i], Integer.MAX_VALUE);

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(map[i][j] == 'J') nodes.offer(new int[]{i, j, 1});
                if(map[i][j] == 'F') fire.offer(new int[]{i, j, 1});
            }
        }

        bfs();

        System.out.println(result == Integer.MAX_VALUE ? "IMPOSSIBLE" : result);
    }

    static void bfs(){
        boolean[][] isVisited = new boolean[R][C];
        while(!fire.isEmpty()){
            int[] pos = fire.poll();
            int curX = pos[0];
            int curY = pos[1];
            int time = pos[2];

            if(isVisited[curX][curY]) continue;

            isVisited[curX][curY] = true;
            fireTime[curX][curY] = time;

            for(int[] delta: deltas){
                int nextX = curX + delta[0];
                int nextY = curY + delta[1];

                if(inRange(nextX, nextY) && map[nextX][nextY] == '.')
                    fire.offer(new int[]{nextX, nextY, time + 1});
            }
        }

        isVisited = new boolean[R][C];

        while(!nodes.isEmpty()){
            int[] pos = nodes.poll();
            int curX = pos[0];
            int curY = pos[1];
            int time = pos[2];

            if(isVisited[curX][curY]) continue;
            if(curX == R - 1 || curY == C - 1 || curX == 0 || curY == 0) result = Math.min(result, time);

            isVisited[curX][curY] = true;

            for(int[] delta: deltas){
                int nextX = curX + delta[0];
                int nextY = curY + delta[1];

                if(inRange(nextX, nextY) && !isVisited[nextX][nextY] && !isVisited[nextX][nextY]
                        && map[nextX][nextY] == '.' && time + 1 < fireTime[nextX][nextY])
                    nodes.offer(new int[]{nextX, nextY, time + 1});
            }
        }
    }

    static boolean inRange(int x, int y){
        return -1 < x && x < R && -1 < y && y < C;
    }
}