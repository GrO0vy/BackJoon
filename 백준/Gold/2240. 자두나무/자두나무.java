import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] arr = new int[T + 1];
        for(int i = 1; i <= T; i++) arr[i] = Integer.parseInt(br.readLine());

        int[][] dp = new int[T + 1][W + 1];

        for(int i = 1; i <= T; i++){
            int cur = arr[i];

            if(cur == 1) dp[i][0] = dp[i - 1][0] + 1;
            else dp[i][0] = dp[i - 1][0];

            for(int j = 1; j <= W; j++){
                if(cur == 1){
                    if(j % 2 == 0) dp[i][j] = Math.max(dp[i - 1][j] + 1, dp[i - 1][j - 1]);
                    else dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i - 1][j]);
                }
                else{
                    if(j % 2 == 0) dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i - 1][j]);
                    else dp[i][j] = Math.max(dp[i - 1][j] + 1, dp[i - 1][j - 1]);
                }
            }
        }

        int answer = 0;
        for(int i = 0; i <= W; i++) answer = Math.max(answer, dp[T][i]);

        System.out.println(answer);
    }
}