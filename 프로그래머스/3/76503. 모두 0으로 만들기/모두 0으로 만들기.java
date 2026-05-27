import java.util.*;

class Solution {
    long cnt;
    List<List<Integer>> adjList;
    boolean[] visited;
    int[] costs;
    
    public long solution(int[] a, int[][] edges) {
        long answer = -2;
        
        costs = a;
        adjList = new ArrayList<>();
        for(int i = 0; i < a.length; i++) adjList.add(new ArrayList<>());
        
        for(int[] edge: edges){
            int node1 = edge[0];
            int node2 = edge[1];
            
            adjList.get(node1).add(node2);
            adjList.get(node2).add(node1);
        }
        
        visited = new boolean[a.length];
        visited[0] = true;
        
        long result = operation(0);
        answer = cnt;
        
        if(result != 0) return -1;
        
        return answer;
    }
    
    long operation(int node){
        long remain = 0;
        
        for(int i = 0; i < adjList.get(node).size(); i++){
            int next = adjList.get(node).get(i);
            
            if(!visited[next]){
                visited[next] = true;
                long r = operation(next);
                cnt += Math.abs(r);
                remain += r;
            }
        }
        
        return remain + costs[node];
    }
}