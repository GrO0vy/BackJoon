class Solution {
    public long solution(long n) {
        long answer = -1;
        
        if(Math.sqrt(n) == (long)Math.sqrt(n)) answer = (long)Math.pow((long)Math.sqrt(n) + 1, 2);
        return answer;
    }
}