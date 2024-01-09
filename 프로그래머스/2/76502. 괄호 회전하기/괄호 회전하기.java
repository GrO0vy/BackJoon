import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String str = s + s;
        int start = 0;
        
        for(int i = 0; i < s.length(); i++){
            String current = str.substring(start, start + s.length());
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            
            for(int j = 0; j < current.length(); j++){
                char letter = current.charAt(j);
                if(isOpen(letter)) stack.push(letter);
                else{
                    if(stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    
                    char top = stack.pop();
                    if(letter == ']' && top != '[') {
                        flag = false;
                        break;
                    }
                    if(letter == '}' && top != '{') {
                        flag = false;
                        break;
                    }
                    if(letter == ')' && top != '(') {
                        flag = false;
                        break;
                    }
                }
            }
            
            if(!stack.isEmpty()) flag = false;
            if(flag) answer++;
            start++;
        }
        
        return answer;
    }
    
    boolean isOpen(char simbol){
        return simbol == '[' || simbol == '{' || simbol == '(';
    }
}