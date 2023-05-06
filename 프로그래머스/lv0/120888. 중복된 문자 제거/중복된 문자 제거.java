class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        
        while(my_string.length() >0){
            answer+=my_string.charAt(0);
            my_string = my_string.replace(String.valueOf(my_string.charAt(0)),"");
        }
        return answer;
    }
}