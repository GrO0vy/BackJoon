import java.io.*;
import java.util.*;

public class Main{
    static List<List<Edge>> adjList;
    static int N;
    static int M;
    static int start;
    static int destination;
    static long money;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        destination = Integer.parseInt(st.nextToken());
        money = Long.parseLong(st.nextToken());
        
        adjList = new ArrayList<>();
        for(int i = 0; i <= N; i++) adjList.add(new ArrayList<>());

        long max = 0;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            adjList.get(node1).add(new Edge(node2, cost));
            adjList.get(node2).add(new Edge(node1, cost));
            max += cost;
        }
        
        System.out.println(getMinCost(0, max));
    }
    
    static long getMinCost(long min, long max){
        long result = -1;
        
        while(min <= max){
            long mid = (min + max) / 2;
            
            if(isPossible(mid)){
                result = mid;
                max = mid - 1;
            }
            else min = mid + 1;
        }
        
        return result;
    }
    static boolean isPossible(long limit){
        long[] cost = new long[N + 1];
        Arrays.fill(cost, Long.MAX_VALUE);
        cost[start] = 0;
        
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) ->{
           return Long.compare(o1.cost, o2.cost);
        });
        pq.offer(new Edge(start, 0));
        
        while(!pq.isEmpty()){
            Edge current = pq.poll();
            
            if(current.cost > cost[current.destination]) continue;

            for(Edge edge: adjList.get(current.destination)){
                if(edge.cost > limit) continue;
                
                long nextCost = cost[current.destination] + edge.cost;

                if(nextCost > money) continue;

                if(nextCost < cost[edge.destination]){
                    cost[edge.destination] = nextCost;
                    pq.offer(new Edge(edge.destination, nextCost));
                }
            }
        }
        
        return cost[destination] <= money;
    }
    
    static class Edge{
        int destination;
        long cost;
        
        public Edge(int destination, long cost){
            this.destination = destination;
            this.cost = cost;
        }
    }
}