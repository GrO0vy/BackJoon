import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i <= n; i++) adjList.add(new ArrayList<>());
        
        for(int[] e: edge){
            int node1 = e[0];
            int node2 = e[1];
            
            adjList.get(node1).add(node2);
            adjList.get(node2).add(node1);
        }
        
        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];
        
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        visited[1] = true;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> distance[o1] - distance[o2]);
        pq.offer(1);
        
        while(!pq.isEmpty()){
            int current = pq.poll();
            
            for(int next: adjList.get(current)){
                if(!visited[next]){
                    visited[next] = true;
                    distance[next] = distance[current] + 1;
                    pq.offer(next);
                }
            }
        }
        
        int maxDistance = 0;
        for(int i = 2; i <= n; i++){
            if(distance[i] == maxDistance) answer++;
            
            if(distance[i] > maxDistance){
                answer = 1;
                maxDistance = distance[i];
            }    
        }
        
        return answer;
    }
    
    class Node{
        int start;
        int end;
        int distance;
        
        public Node(int start, int end, int distance){
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }
}