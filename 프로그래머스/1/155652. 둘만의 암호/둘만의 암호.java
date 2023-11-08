class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int count = 0;
            
            while(count < index){
                if(c < 'z') c++;
                else c = 'a';
                
                if(skip.contains(c+"")) continue;
                else count++;
            }
            
            answer += c;
        }
        return answer;
    }
}