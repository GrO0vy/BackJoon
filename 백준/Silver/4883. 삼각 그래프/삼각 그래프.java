import java.io.*;
import java.util.*;

public class Main{
    static int[][] deltas = {{1, 0}, {0, 1}, {1, 1}, {1, -1}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int height = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int idx = 1;

        while(height > 0){
            int[][] graph = new int[height][3];
            int[][] dp = new int[height][3];

            for(int i = 0; i < height; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 3; j++){
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < height; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[0][1] = graph[0][1];

            for(int i = 0; i < height; i++){
                for(int j = 0; j < 3; j++){
                    if(i == 0 && j == 0) continue;
                    for(int[] delta: deltas){
                        int nextX = i + delta[0];
                        int nextY = j + delta[1];
                        if(inRange(nextX, nextY, height)) {
                            dp[nextX][nextY] = Math.min(dp[nextX][nextY], dp[i][j] + graph[nextX][nextY]);
                        }
                    }
                }
            }

            sb.append(String.format("%d. %d\n",idx++, dp[height - 1][1]));
            height = Integer.parseInt(br.readLine());
        }

        System.out.println(sb);
    }

    static boolean inRange(int x, int y, int height){
        return -1 < x && x < height && -1 < y && y < 3;
    }
}