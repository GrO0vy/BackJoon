class Solution {
    public String solution(int n) {
        String answer = "";
        answer = "수박".repeat(n/2) + ( n % 2 == 0 ? "" : "수" );
        return answer;
    }
}