import java.util.*;

class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int[][][] dp = new int[3][m][n];
        dp[0][0][0] = 1;
        dp[1][0][0] = 1;
        dp[2][0][0] = 1;
        
        for(int x = 0; x < m; x++){
            for(int y = 0; y < n; y++){
                if(cityMap[x][y] == 1) continue;
                
                if(cityMap[x][y] == 0){
                    if(y < n - 1){
                        dp[0][x][y + 1] += dp[2][x][y];
                        dp[2][x][y + 1] += dp[2][x][y];
                        dp[0][x][y + 1] %= MOD;
                        dp[2][x][y + 1] %= MOD;    
                    }
                    
                    if(x < m - 1){
                        dp[1][x + 1][y] += dp[2][x][y];
                        dp[2][x + 1][y] += dp[2][x][y];
                        dp[1][x + 1][y] %= MOD;
                        dp[2][x + 1][y] %= MOD;    
                    }
                }
                else{
                    if(y < n - 1){
                        dp[0][x][y + 1] += dp[0][x][y];
                        dp[2][x][y + 1] += dp[0][x][y];
                        dp[0][x][y + 1] %= MOD;
                        dp[2][x][y + 1] %= MOD;    
                    }
                    
                    if(x < m - 1){
                        dp[1][x + 1][y] += dp[1][x][y];
                        dp[2][x + 1][y] += dp[1][x][y];
                        dp[1][x + 1][y] %= MOD;
                        dp[2][x + 1][y] %= MOD;    
                    }
                }
            }
        }
        
        return dp[2][m - 1][n - 1];
    }
}