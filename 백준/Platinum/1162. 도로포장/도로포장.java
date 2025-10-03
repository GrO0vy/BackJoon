import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int K;
    static List<List<Edge>> edges;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        edges = new ArrayList<>();
        for(int i = 0; i <= N; i++) edges.add(new ArrayList<>());
        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            
            edges.get(node1).add(new Edge(node2, time, 0));
            edges.get(node2).add(new Edge(node1, time, 0));
        }
        
        System.out.println(getMinDistance());
    }
    
    static long getMinDistance(){
        long[][] times = new long[N + 1][K + 1];
        for(int i = 1; i <= N; i++) Arrays.fill(times[i], Long.MAX_VALUE);
        times[1][0] = 0;
        
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.time, o2.time));
        pq.offer(new Edge(1, 0, 0));
        
        while(!pq.isEmpty()){
            Edge current = pq.poll();
            
            if(current.time > times[current.destination][current.cnt]) continue;
            
            for(Edge edge: edges.get(current.destination)){
                if(current.cnt < K && current.time < times[edge.destination][current.cnt + 1]){
                    times[edge.destination][current.cnt + 1] = current.time;
                    pq.offer(new Edge(edge.destination, current.time, current.cnt + 1));
                }
                
                if(current.time + edge.time < times[edge.destination][current.cnt]){
                    times[edge.destination][current.cnt] = current.time + edge.time;
                    pq.offer(new Edge(edge.destination, current.time + edge.time, current.cnt));
                }
            }
        }
        
        long minDistance = Long.MAX_VALUE;
        for(int i = 0; i <= K; i++) minDistance = Math.min(minDistance, times[N][i]);
        
        return minDistance;
    }
    
    static class Edge{
        int destination;
        long time;
        int cnt;
        
        public Edge(int destination, long time, int cnt){
            this.destination = destination;
            this.time = time;
            this.cnt = cnt;
        }
    }
}