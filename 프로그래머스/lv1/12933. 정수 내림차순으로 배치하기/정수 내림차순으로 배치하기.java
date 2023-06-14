import java.util.*;
class Solution {
    public long solution(long n) {
        int size = (n+"").length();
        int[] digits = new int[size];
        long answer = 0;
        
        
        for(int i = 0; n > 0; i++){
            digits[i] = (int) (n % 10);
            n /= 10;
        }
        Arrays.sort(digits);
        
        for(int i =digits.length-1; i >= 0; i--){
            answer = answer * 10 + digits[i];
        }
        
        return answer;
    }
}