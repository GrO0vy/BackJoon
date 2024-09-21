class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int start = 1;
        int end = 100000;
        
        while(start < end){
            int mid = (start + end) / 2;
            long totalTime = puzzle(mid, diffs, times);
            
            if(totalTime > limit){
                start = mid + 1;    
            }
            else {
                end = mid;
            }
        }
        
        answer = start;
        
        return answer;
    }
    
    public long puzzle(int level, int[] diffs, int[] times){
        long totalTime = 0;
        long timePrev = 0; 
        
        for(int i = 0; i < diffs.length; i++){
            int wrong = Math.max(0, diffs[i] - level);
            
            totalTime += times[i] * (wrong + 1) + timePrev * wrong;
            timePrev = times[i];
        }
        
        return totalTime;
    } 
}