import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < number.length(); i++){
            char num = number.charAt(i);
            if(k == 0 || stack.isEmpty()) stack.push(num);
            else{
                if(stack.peek() < num){
                    while(!stack.isEmpty() && k > 0 && stack.peek() < num) {
                        stack.pop();
                        k--;
                    }
                }
                
                stack.push(num);
            }
        }
        
        if(k > 0){
            while(k > 0){
                stack.pop();
                k--;
            }
        }
        
        while(!stack.isEmpty()) answer = stack.pop() + answer;
        return answer;
    }
}