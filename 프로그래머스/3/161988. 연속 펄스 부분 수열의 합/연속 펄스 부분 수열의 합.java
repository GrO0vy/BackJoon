import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        int[] pulse1 = sequence.clone();
        int[] pulse2 = sequence.clone();
        
        for(int i = 0; i < sequence.length; i++){
            if(i % 2 == 0) pulse1[i] *= -1;
            else pulse2[i] *= -1; 
        }
        
        return Math.max(findMax(pulse1), findMax(pulse2));
    }
    
    long findMax(int[] sequence){
        long max = -100001;
        long sum = 0;
        
        for(int i = 0; i < sequence.length; i++){
            max = Math.max(max, sum + sequence[i]);
            
            if(sum + sequence[i] < 0) {
                sum = 0;
                continue;
            }
            
            sum += sequence[i];
        }
        
        return max;
    }
}