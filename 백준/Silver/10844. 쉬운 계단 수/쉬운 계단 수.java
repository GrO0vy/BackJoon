import java.io.*;

public class Main{
    static Long[][] dp;
    static final int MOD = 1000000000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new Long[N + 1][10];
        for(int i = 0; i <= 9; i++) dp[1][i] = 1L;

        long result = 0;
        for(int i = 2; i <= N; i++){
            dp[i][0] = dp[i - 1][1] % MOD;
            for(int j = 1; j <= 8; j++){
                dp[i][j] = (dp[i - 1][j - 1] % MOD + dp[i - 1][j + 1] % MOD) % MOD;
            }
            dp[i][9] = dp[i - 1][8] % MOD;
        }

        for(int i = 1; i <= 9; i++){
            result = (result + dp[N][i]) % MOD;
        }
        System.out.println(result);
    }
}