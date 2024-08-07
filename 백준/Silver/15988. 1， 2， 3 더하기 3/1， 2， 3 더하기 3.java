import java.io.*;

public class Main{
    static final int MOD = 1000000009;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());

            long[] dp = new long[n + 3];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for(int j = 4; j <= n; j++){
                for(int k = 1; k <= 3; k++){
                    dp[j] += dp[j - k];
                }
                dp[j] %= MOD;
            }

            System.out.println(dp[n]);
        }
    }
}