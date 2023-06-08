class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        
        int iter = my_string.length() / m + (my_string.length() % m >= c ? 1 : 0);
        
        for(int i = 0; i < iter; i++){
            answer += my_string.charAt(i*m + c - 1);
        }
        return answer;
    }
}