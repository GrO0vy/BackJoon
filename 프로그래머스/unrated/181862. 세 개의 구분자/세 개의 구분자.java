class Solution {
    public String[] solution(String myStr) {
        String[] answer = {};
        myStr = myStr.replaceAll("[a-c]"," ").replaceAll("\\s+", " ").trim();
        
        if(myStr.length() == 0){
            answer = new String[1];
            answer[0] = "EMPTY";
        }
        else{
            answer = myStr.split(" ");
        }
        
        return answer;
    }
}