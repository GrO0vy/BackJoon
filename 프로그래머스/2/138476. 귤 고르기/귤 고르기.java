import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Arrays.sort(tangerine);
        int max = tangerine[tangerine.length - 1];
        
        int[] arr = new int[max + 1];
        for(int i = 0; i < tangerine.length; i++){
            arr[tangerine[i]]++;
        }
        
        Arrays.sort(arr);
        
        int idx = max;
        while(k > 0 && idx > 0){
            k -= arr[idx];
            answer++;
            idx--;
        }
        
        return answer;
    }
}