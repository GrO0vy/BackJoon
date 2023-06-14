class Solution {
    public boolean solution(int x) {
        boolean answer = false;
        int num = x;
        int sumDigit = 0;
        
        while(x > 0){
            sumDigit += x % 10;
            x /= 10;
        }
        
        if(num % sumDigit == 0) answer = true;
        return answer;
    }
}