import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String base = tenToK(n, k);
        
        if(!base.contains("0")){
            if(isPrime(Long.parseLong(base))) answer = 1;
        }
        else{
            String[] arr = base.split("0+");
        
            for(String baseNum: arr){
                if(isPrime(Long.parseLong(baseNum))) answer++;
            }    
        }
        
        return answer;
    }
    
    public String tenToK(long n, int k){
        String base = "";
        while(n >= k){
            base = (n % k) + base;
            n /= k;
        }
        base = n + base;
        
        return base;
    }
    
    public boolean isPrime(long n){
        if(n == 1) return false;
        
        for(int i = 2; i <= (int)Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }        
        
        return true;
    }
}