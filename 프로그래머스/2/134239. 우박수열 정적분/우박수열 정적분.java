import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = {};
        
        List<Integer> pos = new ArrayList<>();
        pos.add(k);
        
        int K = k;
        
        for(int i = 1; K > 1; i++){
            if(K % 2 == 0) K /= 2;
            else K = K * 3 + 1;
            
            pos.add(K);
        }
        
        double[] area = new double[pos.size()];
        
        for(int i = 1; i < pos.size(); i++){
            int prev = pos.get(i - 1);
            int cur = pos.get(i);
            
            area[i] = area[i - 1] + (prev + cur) / 2.0;
        }
        
        answer = new double[ranges.length];
        
        for(int i = 0; i < ranges.length; i++){
            int start = ranges[i][0];
            int end = pos.size() - 1 + ranges[i][1];
            double curArea = -1;
            
            if(start <= end) curArea = area[end] - area[start];
    
            answer[i] = curArea;
        }
        
        return answer;
    }
}