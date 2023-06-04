class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        int length = my_string.length();
        
        for(int i = length-1; i >= length -n; i--){
            answer = my_string.charAt(i) + answer;
        }
        return answer;
    }
}