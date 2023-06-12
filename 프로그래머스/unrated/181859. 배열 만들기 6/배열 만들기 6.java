import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {-1};
        Stack<Integer> stk = new Stack<>();
        int i = 0;
        
        while(i < arr.length){
            if(stk.size() == 0) stk.push(arr[i]);
            else{
                if(stk.peek() == arr[i]) {
                    stk.pop();
                }
                else{
                    stk.push(arr[i]);
                }
            }
            i++;
        }
        
        if(stk.size() > 0){
            answer = new int[stk.size()];
            for(int j = answer.length-1; j >= 0; j--){
                answer[j] = stk.pop();
            }
        }
        
        return answer;
    }
}