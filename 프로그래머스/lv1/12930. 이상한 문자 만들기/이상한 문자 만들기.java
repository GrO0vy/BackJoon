class Solution {
    public String solution(String s) {
        String answer = "";
        
        int cnt = 0;
        
        String[] letters = s.split("");
        
        for(String token : letters){
            cnt = token.equals(" ") ? 0 : cnt + 1;
            answer += cnt % 2 == 0 ? token.toLowerCase() : token.toUpperCase();
        }
        return answer;
    }
}