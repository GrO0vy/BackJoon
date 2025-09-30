import java.util.*;
class Solution {
    public int[] solution(int target) {
        // 1. dp 배열에 각 점수를 만들 수 있는 최소 횟수, 그 때의 싱글/불 횟수 저장
        // --> dp[target][2];
        // 2. 1 ~ target 번 만큼 1 ~ 20 점의 싱글, 더블, 트리플, 불을 실행
        // 3. 최종적으로 dp[target] 을 리턴한다.
        // --> 결국 1 ~ target 점수를 만들 수 있는 경우의 수 중 가장 적은 횟수, 가장 많은 싱글/불 을 가진 경우 저장
        
        int[][] dp = new int[target + 1][2];
        for(int i = 1; i <= target; i++){
            dp[i][0] = 100001;
        }
        
        for(int i = 1; i <= target; i++){
            // 불을 던지는 경우
            if(i - 50 >= 0){
                if(dp[i][0] > dp[i - 50][0] + 1){
                    dp[i][0] = dp[i - 50][0] + 1;
                    dp[i][1] = dp[i - 50][1] + 1;    
                }
                else if(dp[i][0] == dp[i - 50][0] + 1){
                    dp[i][1] = Math.max(dp[i][1], dp[i - 50][1] + 1);
                }  
            }
            
            for(int score = 1; score <= 20; score++){
                // 싱글을 던지는 경우
                if(i - score >= 0){
                    if(dp[i][0] > dp[i - score][0] + 1){
                        dp[i][0] = dp[i - score][0] + 1;
                        dp[i][1] = dp[i - score][1] + 1;
                    }
                    else if(dp[i][0] == dp[i - score][0] + 1){
                        dp[i][1] = Math.max(dp[i][1], dp[i - score][1] + 1);
                    }
                }
                
                // 더블을 던지는 경우
                if(i - score * 2 >= 0){
                    if(dp[i][0] > dp[i - score * 2][0] + 1){
                        dp[i][0] = dp[i - score * 2][0] + 1;
                        dp[i][1] = dp[i - score * 2][1];
                    }
                    // else if(dp[i][0] == dp[i - score * 2][0] + 1){
                    //     dp[i][1] = Math.max(dp[i][1], dp[i - score * 2][1]);
                    // }
                }
                
                // 트리플을 던지는 경우
                if(i - score * 3 >= 0){
                    if(dp[i][0] > dp[i - score * 3][0] + 1){
                        dp[i][0] = dp[i - score * 3][0] + 1;
                        dp[i][1] = dp[i - score * 3][1];
                    }
                    // else if(dp[i][0] == dp[i - score * 3][0] + 1){
                    //     dp[i][0] = Math.max(dp[i][1], dp[i - score * 3][1]);
                    // }
                }
            }
        }

        return dp[target];
    }
}