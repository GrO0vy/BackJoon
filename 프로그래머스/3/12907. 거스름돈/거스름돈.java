import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        
        Arrays.sort(money);
        
        int[][] dp = new int[money.length][n + 1];
        
        for(int i = 0; i < money.length; i++) dp[i][0] = 1;
        for(int i = 1; i <= n; i++) {
            if(i % money[0] == 0) dp[0][i] = 1;
        }
        
        for(int i = 1; i < money.length; i++){
            for(int j = 1; j <= n; j++){
                if(j < money[i]) dp[i][j] = dp[i - 1][j];
                else dp[i][j] += dp[i - 1][j] + dp[i][j - money[i]];    
            }
        }
        
        return dp[money.length - 1][n];
    }
}