class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        long[][] dp = new long[2][sequence.length + 1];
        
        for(int i = 1; i <= sequence.length; i++){
            if(i % 2 == 0){
                dp[0][i] = Math.max(dp[0][i - 1] + sequence[i - 1] * -1, sequence[i - 1] * -1);
                dp[1][i] = Math.max(dp[1][i - 1] + sequence[i - 1], sequence[i - 1]);
            }
            else{
                dp[0][i] = Math.max(dp[0][i - 1] + sequence[i - 1], sequence[i - 1]);
                dp[1][i] = Math.max(dp[1][i - 1] + sequence[i - 1] * -1, sequence[i - 1] * - 1);
            }
            
            answer = Math.max(answer, Math.max(dp[0][i], dp[1][i]));
            
        }
        return answer;
    }
}