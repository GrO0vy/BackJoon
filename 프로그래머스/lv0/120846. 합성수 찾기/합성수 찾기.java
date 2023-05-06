class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i =1; i<=n; i++){
            int divisorCnt = 0;
            for(int j=1; j<=i; j++){
                if(i % j == 0) {
                    divisorCnt++;
                    if(divisorCnt > 2){
                        answer++;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}