import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; n > 0; i++){
            stack.push(n % 3);
            n /= 3;
        }
        
        for(int i = 0; stack.size() > 0; i++){
            answer += stack.pop() * Math.pow(3,i);
        }
        
        return answer;
    }
}