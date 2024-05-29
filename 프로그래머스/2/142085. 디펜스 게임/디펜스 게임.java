import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        int idx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> enemy[o2] - enemy[o1]);
        
        while(idx < enemy.length && n >= 0){
            n -= enemy[idx];
            pq.offer(idx);
            
            if(n < 0 && k > 0){
                n += enemy[pq.poll()];
                k--; 
            }
            
            idx++;
        }
        
        if(n < 0) answer = idx - 1;
        else answer = enemy.length;
        
        return answer;
    }
}