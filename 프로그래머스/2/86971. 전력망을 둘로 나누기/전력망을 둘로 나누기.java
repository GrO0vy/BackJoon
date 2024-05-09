import java.util.*;

class Solution {
    List<List<Integer>> adjList;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        adjList = new ArrayList<>();
        for(int i = 0; i <= n; i++) adjList.add(new ArrayList<>());
        
        for(int[] wire : wires){
            adjList.get(wire[0]).add(wire[1]);
            adjList.get(wire[1]).add(wire[0]);
        }
        
        for(int[] wire: wires){
            boolean[] visited = new boolean[n + 1];
            int[] cnt = new int[2];
            int idx = 0;
            
            for(int i = 1; i <= n; i++){
                if(!visited[i]) cnt[idx++] = dfs(i, wire, visited, 1);
            }
            
            answer = Math.min(answer, Math.abs(cnt[0] - cnt[1]));
        }
        return answer;
    }
    
    int dfs(int node, int[] skip, boolean[] visited, int cnt){
        visited[node] = true;
        for(int next: adjList.get(node)){
            if(visited[next] || (node == skip[0] && next == skip[1]) || 
               (node == skip[1] && next == skip[0]))
            {
                continue;
            }
            
            cnt += dfs(next, skip, visited, 1);    
        }
        
        return cnt;
    }
}