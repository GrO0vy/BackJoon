import java.util.*;

class Solution {
    final String ADD_STR = "110";
    
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for(int i = 0; i < s.length; i++){
            String str = s[i];
            
            answer[i] = makeStr(str);    
        }
        
        return answer;
    }
    
    String makeStr(String origin){
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < origin.length(); i++){
            char c = origin.charAt(i);
            
            stack.push(c);
            
            if(stack.size() >= 3){
                if(stack.peek() == '0' && stack.get(stack.size() - 2) == '1' && stack.get(stack.size() -3) == '1'){
                    for(int j = 0; j < 3; j++) stack.pop();
                    cnt++;
                }
            }
        }
        
        while(!stack.isEmpty()){
            char c = stack.pop();
            
            if(c == '1') sb.insert(0, c);
            else{
                while(cnt > 0){
                    sb.insert(0, ADD_STR);
                    cnt--;
                }
                
                sb.insert(0, c);
            }
        }
        
        for(int i = 0; i < cnt; i++){
            sb.insert(0, ADD_STR);
        }
        
        return sb.toString();
    }
}