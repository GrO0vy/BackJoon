import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        List<List<int[]>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        
        for(int[] cost: costs){
            int node1 = cost[0];
            int node2 = cost[1];
            
            adjList.get(node1).add(new int[]{node2, cost[2]});
            adjList.get(node2).add(new int[]{node1, cost[2]});
        }
        
        boolean[] visited = new boolean[n];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]- o2[1]);
        pq.offer(new int[]{0, 0});
        
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            
            if(visited[node[0]]) continue;
            
            visited[node[0]] = true;
            answer += node[1];
            
            for(int[] next: adjList.get(node[0])){
                pq.offer(next);
            }
        }
        return answer;
    }
}