import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        List<Integer> list = new ArrayList<>();
        
        int complete = 0;
        int start = 0;
        
        while(complete < progresses.length){
            int cnt = 0;
            for(int i = start; i < progresses.length; i++){
                if(progresses[i] < 100) break;
                start++;
                complete++;
                cnt++;
            }
            
            if(cnt > 0 ) list.add(cnt);
            
            for(int i = start; i < progresses.length; i++){
                progresses[i] += speeds[i];
            }
            
        }
        
        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}