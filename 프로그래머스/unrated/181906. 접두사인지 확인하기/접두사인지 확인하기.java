class Solution {
    public int solution(String my_string, String is_prefix) {
        int answer = 0;
        String pre ="";
        
        if(my_string.length() >= is_prefix.length()){
            for(int i=0; i<is_prefix.length(); i++){
                pre += my_string.charAt(i);
            }
        }
        
        if(pre.equals(is_prefix)) answer = 1;
        return answer;
    }
}