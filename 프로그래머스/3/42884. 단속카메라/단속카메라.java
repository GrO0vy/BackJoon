import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>(){
            public int compare(int[] o1, int[] o2){
                return o1[1] - o2[1];
            }
        });
        
        for(int[] route: routes) pq.offer(route);
        
        while(!pq.isEmpty()){
            int[] front = pq.poll();
            
            while(!pq.isEmpty() && front[1] >= pq.peek()[0]){
                pq.poll();
            }
            
            answer++;
        }
        
        return answer;
    }
}