import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        
        boolean[] selected = new boolean[cards.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
        for(int i = 0; i < selected.length; i++){
            if(!selected[i]) pq.offer(dfs(cards[i], cards, selected));
        }
        
        if(pq.size() > 1)
            answer = pq.poll() * pq.poll();
        
        return answer;
    }
    
    int dfs(int card, int[] cards, boolean[] selected){
        if(selected[card - 1]) return 0;
        
        selected[card - 1] = true;
        return 1 + dfs(cards[card - 1], cards, selected);
    }
}