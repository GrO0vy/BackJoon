import java.util.*;

class Solution {
    public int solution(int[] money) {
        return Math.max(calMax(Arrays.copyOfRange(money, 0, money.length - 1)), calMax(Arrays.copyOfRange(money, 1, money.length)));
    }
    
    int calMax(int[] money){
        int max = 0;
        
        int[] dp = new int[money.length + 1];
        dp[1] = money[0];
        
        for(int i = 1; i < money.length; i++){
            dp[i + 1] = Math.max(dp[i - 1] + money[i], dp[i]);                
        }
        
        return dp[money.length];
    }
}