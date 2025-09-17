import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        
        Set<Integer>[] dp = new HashSet[9];
        for(int i = 0; i < 9; i++) dp[i] = new HashSet<>();
        
        for(int i = 1; i < 9; i++){
            dp[i].add(Integer.parseInt(String.valueOf(N).repeat(i)));
            
            for(int j = 1; j < i; j++){
                for(int num1: dp[j]){
                    for(int num2: dp[i - j]){
                        dp[i].add(num1 + num2);
                        dp[i].add(num1 - num2);
                        dp[i].add(num1 * num2);
                        if(num2 != 0) dp[i].add(num1 / num2);
                    }
                }
            }
            
            if(dp[i].contains(number)){
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}