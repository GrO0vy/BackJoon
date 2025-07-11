import java.util.*;
import java.io.*;

public class Main{
    static int[][] map;
    static int N;
    static int M;
    static int max;
    static List<int[]> sources;
    static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        sources = new ArrayList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++){
                int value = Integer.parseInt(st.nextToken());

                if(value == 2){
                    sources.add(new int[]{i, j});
                }

                map[i][j] = value;
            }
        }

        dfs(0);

        System.out.println(max);
    }

    static void dfs(int wall){
        if(wall == 3){
            bfs();
            return;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void bfs(){
        boolean[][] visited = new boolean[N][M];

        Queue<int[]> queue = new LinkedList<>();
        for(int[] source: sources) queue.offer(source);

        while(!queue.isEmpty()){
            int[] current = queue.poll();

            for(int[] delta: deltas){
                int nextX = current[0] + delta[0];
                int nextY = current[1] + delta[1];

                if(inRange(nextX, nextY) && !visited[nextX][nextY] && map[nextX][nextY] == 0){
                    visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }

        calMax(visited);
    }

    static void calMax(boolean[][] visited){
        int safe = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j] && map[i][j] == 0) safe++;
            }
        }

        max = Math.max(max, safe);
    }

    static boolean inRange(int x, int y){
        return -1 < x && x < N && -1 < y && y < M;
    }
}