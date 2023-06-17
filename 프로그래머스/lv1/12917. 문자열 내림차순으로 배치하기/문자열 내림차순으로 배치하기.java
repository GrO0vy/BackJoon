import java.util.Arrays;
class Solution {
    public String solution(String s) {
        String answer = "";
        
        char[] letters = s.toCharArray();
        Arrays.sort(letters);
        
        for(int i = letters.length-1; i >= 0; i--){
            answer += letters[i];
        }
        
        return answer;
    }
}