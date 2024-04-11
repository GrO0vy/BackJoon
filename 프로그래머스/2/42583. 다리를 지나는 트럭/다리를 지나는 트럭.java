import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
     
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < bridge_length; i++) queue.offer(0);
        
        int idx = 0;
        int totalWeight = 0;
        int cntCar = 0;
        
        while(idx < truck_weights.length){
            int next = queue.poll();
            if(next > 0) cntCar--;
            totalWeight -= next;
            answer++;
            
            
            if(cntCar < bridge_length &&
               totalWeight + truck_weights[idx] <= weight)
            {
                totalWeight += truck_weights[idx];
                queue.offer(truck_weights[idx++]);
                cntCar++;
            }
            
            else queue.offer(0);
        }
        
        answer += bridge_length;
        return answer;
    }
}