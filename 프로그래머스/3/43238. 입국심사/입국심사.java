import java.util.*;


class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        
        long left = 1;
        long right = (long) Arrays.stream(times).max().getAsInt() * n;
        long mid = right;
        
        while(left <= right){
            long people = calAvailibity(times, mid);
            
            if(people >= n){
                answer = Math.min(answer, mid);
                right = mid - 1;
            }
            else{
                left = mid + 1;    
            }
            
            mid = left + (right - left) / 2;
        }
        
        return answer;
    }
    
    private long calAvailibity(int[] times, long totalTime){
        long sum = 0;
        
        for(int time: times) sum += totalTime / time;
        
        return sum;
    }
}