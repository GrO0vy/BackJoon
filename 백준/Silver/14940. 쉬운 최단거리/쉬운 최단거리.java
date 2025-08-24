import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static int m;

    static final int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] start = {-1, -1, -1};
        int[][] map = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) start = new int[]{i, j, 0};
            }
        }

        bfs(start, map);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static void bfs(int[] start, int[][] map){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);

        boolean[][] visited = new boolean[n][m];
        visited[start[0]][start[1]] = true;
        map[start[0]][start[1]] = 0;

        while(!queue.isEmpty()){
            int[] current = queue.poll();

            for(int[] delta: deltas){
                int nextX = current[0] + delta[0];
                int nextY = current[1] + delta[1];

                if(inRange(nextX, nextY) && !visited[nextX][nextY] && map[nextX][nextY] == 1){
                    visited[nextX][nextY] = true;
                    map[nextX][nextY] = current[2] + 1;
                    queue.offer(new int[]{nextX, nextY, current[2] + 1});
                }
            }
        }

        findCantGo(visited, map);
    }

    static boolean inRange(int x, int y){
        return -1 < x && x < n && -1 < y && y < m;
    }

    static void findCantGo(boolean[][] visited, int[][] map){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j] && map[i][j] == 1) map[i][j] = -1;
            }
        }
    }
}