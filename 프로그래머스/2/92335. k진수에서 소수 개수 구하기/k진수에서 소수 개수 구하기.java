import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String[] numbers = Integer.toString(n, k).split("0+");
        
        for(String num: numbers){
            if(isPrime(Long.parseLong(num))) answer++;        
        }
        
        return answer;
    }
    
    private String convert(int num, int k){
        if(num < k) return String.valueOf(num);
        
        return convert(num / k, k) + (num % k);          
    }
    
    private boolean isPrime(long num){
        if(num == 1) return false;
        
        for(int i = 2; i <= (long)Math.sqrt(num); i++){
            if(num % i == 0) return false;       
        }
        
        return true;
    }
}