import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        Arrays.sort(arr);
        int min = arr[0];
        
        for(int i = 1; i < arr.length; i++){
            int maxDivisor = gcd(arr[i], min);
            
            min = arr[i] * (min / maxDivisor);
        }
        
        answer = min;
        return answer;
    }
    
    int gcd(int a, int b){
        if(a % b == 0) return b;
        return gcd(b, a % b);
    }
}