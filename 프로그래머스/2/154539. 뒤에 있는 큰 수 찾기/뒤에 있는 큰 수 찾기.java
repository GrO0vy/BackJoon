import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        
        Arrays.fill(answer, -1);
        
        stack.add(0);
        for(int i = 1; i < numbers.length; i++){
            if(numbers[stack.peek()] < numbers[i]){
                while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) 
                    answer[stack.pop()] = numbers[i];
            }
            
            stack.add(i);
        }
        
        return answer;
    }
}