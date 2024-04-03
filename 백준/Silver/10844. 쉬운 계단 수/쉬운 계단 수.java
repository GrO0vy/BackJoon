import java.io.*;

public class Main{
    static Long[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new Long[N + 1][10];
        for(int i = 0; i <= 9; i++) dp[1][i] = 1L;

        long result = 0;
        for(int i = 1; i <= 9; i++) result += recursion(N, i);

        System.out.println(result % 1000000000);
    }

    static long recursion(int digit, int val){
        if(digit == 1) return dp[digit][val];

        if(dp[digit][val] == null){
            if(val == 0) dp[digit][val] = recursion(digit - 1, 1);
            else if(val == 9) dp[digit][val] = recursion(digit - 1, 8);
            else dp[digit][val] = recursion(digit - 1, val - 1) + recursion(digit - 1, val + 1);
        }

        return dp[digit][val] % 1000000000;
    }
}