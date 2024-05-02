import java.util.*;

class Solution {
    int[] times;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        List<HashMap<Integer, Integer>> map = new ArrayList<>();
        times = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        
        Arrays.fill(times, Integer.MAX_VALUE);
        times[1] = 0;
        
        for(int i = 0; i <= N; i++){
            map.add(new HashMap<>());
        }
        
        for(int i = 0; i < road.length; i++){
            int node1 = road[i][0];
            int node2 = road[i][1];
            int time = road[i][2];
            
            map.get(node1).put(node2, Math.min(map.get(node1).getOrDefault(node2, 10001), time));
            map.get(node2).put(node1, Math.min(map.get(node2).getOrDefault(node1, 10001), time));
        }
   
        for(int i = 1; i <= N; i++){
            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>(){
                public int compare(int[] o1, int[] o2){
                    return o1[1] - o2[1];
                }
            });
            
            for(int j = 1; j <= N; j++){
                if(!visited[j]) pq.offer(new int[]{j, times[j]});
            }
            
            int node = pq.peek()[0];
            visited[node] = true;
            
            for(int key: map.get(node).keySet()){
                times[key] = Math.min(times[key], times[node] + map.get(node).get(key));
            }        
        }
        
        
        for(int i = 1; i <= N; i++){
            if(times[i] <= K) answer++;    
        }
        
        return answer;
    }
}