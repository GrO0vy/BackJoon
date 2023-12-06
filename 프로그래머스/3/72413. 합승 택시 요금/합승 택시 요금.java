import java.util.*;

class Solution {
    ArrayList<int[]>[] adjList;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
    
        adjList = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) adjList[i] = new ArrayList<>();
        
        for(int[] fare: fares){
            int start = fare[0];
            int end = fare[1];
            int weight = fare[2];
            
            adjList[start].add(new int[]{end, weight});
            adjList[end].add(new int[]{start, weight});
        }
        
        
        int[] startA = search(a, n);
        int[] startB = search(b, n);
        int[] startS = search(s, n);

        for(int i = 1; i <= n; i++){
            answer = Math.min(answer, startS[i] + startA[i] + startB[i]);
        }
        
        return answer;
    }
    
    int[] search(int start, int n){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });
        pq.offer(new int[]{start, 0});
        
        int[] minDistance = new int[n + 1];
        for(int i = 1; i <= n; i++){
            if(i == start) minDistance[i] = 0;
            else minDistance[i] = Integer.MAX_VALUE;
        }
        
        boolean[] visited = new boolean[n + 1];
        
        
        while(!pq.isEmpty()){
            int[] info = pq.poll();
            
            if(visited[info[0]]) continue;
            
            visited[info[0]] = true;
            
            for(int[] ver: adjList[info[0]]){
                int vertex = ver[0];
                int weight = ver[1];
                
                if(minDistance[vertex] > minDistance[info[0]] + weight){
                    minDistance[vertex] = minDistance[info[0]] + weight;
                    pq.offer(new int[]{vertex, minDistance[vertex]});
                }
            }
        }
        return minDistance;
    }
}