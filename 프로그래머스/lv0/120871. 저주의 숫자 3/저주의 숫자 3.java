class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int count = 1;
        int num = 1;
        while(count <= n){
            if(!(num % 3 == 0 || isContainThree(num))) count++;
            answer++;
            num++;
        }
        return answer;
    }
    
    public boolean isContainThree(int n){
        while(n > 0){
            if(n % 10 == 3) return true;
            n /= 10;
        }
        return false;
    }
}