class Solution {
    public String solution(String s) {
        String answer = "";
        
        boolean isFirst = true;
        for(String c: s.toLowerCase().split("")){
            answer += isFirst ? c.toUpperCase() : c;
            isFirst = c.equals(" ") ? true: false;
        }
        return answer;
    }
}