import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < s.length(); i++){
            int temp = -1;
            for(int j = i - 1; j >= 0; j--){
                if(s.charAt(i) == s.charAt(j)){
                    temp = i - j;
                    break;
                }
            }
            result.add(temp);
        }
        
        answer = new int[result.size()];
        
        for(int i = 0; i < answer.length; i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}