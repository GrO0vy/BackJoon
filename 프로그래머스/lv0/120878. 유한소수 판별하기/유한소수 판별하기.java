import java.util.HashSet;
class Solution {
    public int solution(int a, int b) {
        int answer = 2;
        int maxDivisor = 1;
        for(int i =2; i <= a; i++){
            if(a % i == 0 && b % i == 0) {
                maxDivisor = i;
            }
        }
        
        b /= maxDivisor;
        
        while(b % 2 == 0) b /= 2;
        while(b % 5 == 0) b /= 5;
        
        if(b == 1) answer = 1;
        
        return answer;
    }
}