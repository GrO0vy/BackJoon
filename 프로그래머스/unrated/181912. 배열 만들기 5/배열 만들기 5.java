import java.util.List;
import java.util.ArrayList;
class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        int[] answer = {};
        
        List<Integer> result = new ArrayList<>();
    
        for(int i = 0; i < intStrs.length; i++){
            String str = intStrs[i].substring(s,s+l);
            if(Integer.parseInt(str) > k) result.add(Integer.parseInt(str));
        }
        
        answer = new int[result.size()];
        
        for(int i = 0; i < answer.length; i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}