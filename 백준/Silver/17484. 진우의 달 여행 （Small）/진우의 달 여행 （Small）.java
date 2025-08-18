import java.io.*;
import java.util.*;

public class Main{
    static int[] delta = {0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][M];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[3][N + 1][M];
        for(int i = 0; i < 3; i++){
            for(int j = 1; j <= N; j++) Arrays.fill(dp[i][j], 10000000);
        }


        for(int i = 1; i <= N; i++){
            for(int j = 0; j < M; j++){
                for(int k = 0; k < 3; k++){
                    if(-1 < j + delta[k] && j + delta[k] < M){
                        dp[k][i][j] = Math.min(dp[k][i][j], dp[(k + 1) % 3][i - 1][j + delta[k]] + map[i][j]);
                        dp[k][i][j] = Math.min(dp[k][i][j], dp[(k + 2) % 3][i - 1][j + delta[k]] + map[i][j]);
                    }
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < M; j++) result = Math.min(result, dp[i][N][j]);
        }
        
        System.out.println(result);
    }
}