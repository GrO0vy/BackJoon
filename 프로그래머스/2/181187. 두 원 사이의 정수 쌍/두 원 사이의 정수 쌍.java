class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
       
        for(int i = 0; i <= r2; i++){
            if(i >= r1){
                long cnt = (long)(Math.sqrt((long)r2 * r2 - (long)i * i));
                answer += cnt * 4 + 2;
            }
            else{
                long cnt = (long)Math.sqrt((long)r2 * r2 - (long)i * i) - (long)Math.ceil(Math.sqrt((long)r1 * r1 - (long)i * i)) + 1;
                
                if(i == 0) answer += cnt * 2;
                else answer += cnt * 4;
            }
        }
        
        return answer;
    }
}