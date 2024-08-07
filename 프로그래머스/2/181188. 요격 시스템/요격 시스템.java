import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o2[1] == o1[1]) return o1[0] - o2[0];
            else return o2[1] - o1[1];
        });
        
        for(int i = 0; i < targets.length; i++) pq.offer(targets[i]);
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int start = cur[0];
            
            while(!pq.isEmpty() && pq.peek()[1] > start){
                start = Math.max(start, pq.poll()[0]); 
            }
            
            answer++;
        }
        
        return answer;
    }
}