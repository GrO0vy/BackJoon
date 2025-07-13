import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int work: works) pq.offer(work);
        
        while(n > 0 && pq.peek() > 0){
            pq.offer(pq.poll() - 1);
            n--;
        }
        
        while(!pq.isEmpty()){
            int work = pq.poll();
            
            answer += (long) work * work;    
        }
        
        return answer;
    }
}