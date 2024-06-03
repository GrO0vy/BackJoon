class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        
        for(int i = 0; i <= d; i += k){
            long cnt = possibleCnt(i, k, d);
            
            answer += cnt;  
        }
        
        return answer;
    }
    
    long possibleCnt(int x, int mul, int limit){
        double lDouble = Math.pow(limit, 2);
        double xDouble = Math.pow(x, 2);
        
        if(lDouble - xDouble < 0) return 0;
        else return ((long)Math.sqrt(lDouble - xDouble)) / mul + 1;
    }
}