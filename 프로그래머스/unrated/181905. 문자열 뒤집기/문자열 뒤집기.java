class Solution {
    public String solution(String my_string, int s, int e) {
        String answer = "";
        
        String reverseSubstring = "";
        for(int i = s; i<=e; i++){
            reverseSubstring = my_string.charAt(i) + reverseSubstring;
        }
        
        answer = my_string.substring(0,s) + reverseSubstring + my_string.substring(e+1);
        return answer;
    }
}