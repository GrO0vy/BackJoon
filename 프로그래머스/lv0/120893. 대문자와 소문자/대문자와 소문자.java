class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        sb.append(my_string);
        
        for(int i=0; i<my_string.length(); i++){
            if((int)my_string.charAt(i) < 97) {
                sb.setCharAt(i,(char)(my_string.charAt(i)+32));
            }
            else{
                sb.setCharAt(i,(char)(my_string.charAt(i)-32));
            }
        }
        answer = sb.toString();
        return answer;
    }
}