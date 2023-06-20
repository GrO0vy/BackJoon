class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for(int i = 0; i < s.length(); i++){
            char token = s.charAt(i);
            if(token == 32) answer += " ";
            else{
                if(token >= 97) answer += (char)(token + n > 122 ? 96 + (token + n) % 122 : token + n); 
                else answer += (char)(token + n > 90 ? 64 + (token + n) % 90 : token + n);
            } 
        }
        return answer;
    }
}