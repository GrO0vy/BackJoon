class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String number = s.replaceAll("[+|-]","");
        
        for(int i = 0; i < number.length(); i++){
            answer = answer * 10 + ((int)number.charAt(i) -48);
        }
        if(s.charAt(0) == '-') answer *= -1; 
        
        return answer;
    }
}