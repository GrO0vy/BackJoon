import java.util.Arrays;
class Solution {
    public String solution(String s) {
        String answer = "";
        
        String temp="";
        for(;s.length() > 0;){
            if(s.indexOf(s.charAt(0),1) == -1){
                temp += s.charAt(0);
            }
            s = s.replaceAll(String.valueOf(s.charAt(0)),"");
        }
        String[] letters = temp.split("");
        Arrays.sort(letters);
        for(int i=0; i<letters.length; i++){
            answer += letters[i];
        }
        return answer;
    }
}