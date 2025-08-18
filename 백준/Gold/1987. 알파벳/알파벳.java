import java.util.*;
import java.io.*;

public class Main{
    static int maxDistance = 0;
    static int R;
    static int C;
    static char[][] map;
    static boolean[] visited;
    static final int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for(int i = 0; i < R; i++){
            map[i] = br.readLine().toCharArray();
        }

        visited = new boolean[26];
        visited[map[0][0] - 'A'] = true;

        dfs(0, 0, 1);


        System.out.println(maxDistance);
    }

    static void dfs(int x, int y, int distance){
        maxDistance = Math.max(maxDistance, distance);

        for(int[] delta: deltas){
            int nextX = x + delta[0];
            int nextY = y + delta[1];

            if(inRange(nextX, nextY) && !visited[map[nextX][nextY] - 'A']){
                visited[map[nextX][nextY] - 'A'] = true;
                dfs(nextX, nextY, distance + 1);
                visited[map[nextX][nextY] - 'A'] = false;
            }
        }
    }

    static boolean inRange(int x, int y){
        return -1 < x && x < R && -1 < y && y < C;
    }
}