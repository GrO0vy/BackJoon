import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        int box = 1;
        
        for(int i = 0; i < order.length; i++){
            if(box == order[i]){
                answer++;
                box++;
            }
            else if(box < order[i]){
                while(box < order[i]) stack.push(box++);
                answer++;
                box++;
            }
            else{
                if(stack.pop() == order[i]) answer++;
                else break;
            }
        }
        return answer;
    }
}