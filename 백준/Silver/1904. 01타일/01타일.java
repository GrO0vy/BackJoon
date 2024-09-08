import java.util.*;

public class Main{
    static final int MOD = 15746;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int[] dp = new int[N + 2];
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3; i <= N; i++) dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        
        System.out.println(dp[N]);
    }
}