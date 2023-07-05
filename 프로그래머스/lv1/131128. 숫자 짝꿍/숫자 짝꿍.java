class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        
        
        for(int i = 9; i >= 0; i--){
            String target = String.valueOf(i);
            int xCount = X.length() - X.replace(target,"").length();
            int yCount = Y.length() - Y.replace(target,"").length();
            int count = xCount > yCount ? yCount : xCount;
            answer += target.repeat(count);
        }
        
        if(answer.length() == 0) return "-1";
        
        if(answer.replace("0","").length() == 0) answer = "0";
        
        return answer;
    }
}