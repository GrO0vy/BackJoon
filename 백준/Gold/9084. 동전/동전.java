import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            int[] coins = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                coins[j] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());
            int[] dp = new int[M + 1];

            for(int j = 0; j < N; j++){
                int coin = coins[j];
                for(int k = 1; k <= M; k++){
                    if(dp[k] > 0 && k + coin <= M) dp[k + coin] += dp[k];
                    if(k % coin == 0) dp[k]++;
                }
            }

            System.out.println(dp[M]);
        }
    }
}
