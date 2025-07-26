import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] bestSet = new int[n];
        
        Arrays.fill(bestSet, s/n);
        
        for(int i = 0; i < s % n; i++){
            bestSet[n - i - 1]++; 
        }
        
        return n > s ? new int[]{-1} : bestSet;
    }
}