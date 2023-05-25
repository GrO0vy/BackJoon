class Solution {
    public long solution(int balls, int share) {
        long answer = 1;
        for(int i = balls; i>balls-share; i--){
            answer *= i;
            answer /= balls - i + 1;
        }
        
        return answer;
    }
}