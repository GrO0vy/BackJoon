import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < prices.length; i++){
            if(stack.isEmpty() || prices[stack.peek()] <= prices[i]) stack.push(i);
            else{
                while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                    int idx = stack.pop();
                    answer[idx] = i - idx; 
                }
                
                stack.push(i);
            }
        }
        while(!stack.isEmpty()){
            int idx = stack.pop();
            answer[idx] = prices.length - idx - 1;
        }
        
        return answer;
    }
}