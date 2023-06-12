class Solution {
    public String solution(String code) {
        String answer = "";
        int mode = 0;
        
        char[] letters = code.toCharArray();
        
        for(int i = 0; i < letters.length; i++){
            if(mode == 0){
                if(letters[i] == '1') mode = 1;
                else{
                    if(i % 2 == 0) answer += letters[i];
                }
            }
            else{
                if(letters[i] == '1') mode = 0;
                else{
                    if(i % 2 == 1) answer += letters[i];
                }
            }
        }
        
        if(answer.length() == 0) answer = "EMPTY";
        return answer;
    }
}