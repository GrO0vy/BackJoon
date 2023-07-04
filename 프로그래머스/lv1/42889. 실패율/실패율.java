import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        List<Double> result = new ArrayList<>();
        
        for(int i = 1; i <= N; i++){
            int fail = 0;
            int reach = 0;
            for(int j = 0; j < stages.length; j++){
                if(stages[j] >= i) reach++;
                if(stages[j] == i) fail++;
            }
            result.add(reach == 0 ? 0 : (double)(fail) / reach);  
        }
        
        for(int i = 0; i < result.size(); i++){
            double max = Collections.max(result);
            int idx = result.indexOf(max);
            
            answer[i] = idx + 1;
            result.set(idx, -1.0);
        }
        
        return answer;
    }
}