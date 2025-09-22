import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int[] parent;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.length - o2.length);
        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            
            pq.offer(new Edge(node1, node2, length));
        }
        
        System.out.println(seperateCity(pq));
    }
    
    static long seperateCity(PriorityQueue<Edge> pq){
        long totalLength = 0;
        int maxPathLen = 0;
        
        parent = new int[N + 1];
        for(int i = 1; i <= N; i++) parent[i] = i;
        
         while(!pq.isEmpty()){
             Edge edge = pq.poll();
             
             if(union(edge.source, edge.destination)){
                 totalLength += edge.length;
                 maxPathLen = edge.length;
             }
         }
        
        return totalLength - maxPathLen;
    }
    
    static int find(int node){
        if(parent[node] == node) return node;
        
        return parent[node] = find(parent[node]);
    }
    
    static boolean union(int node1, int node2){
        int parent1 = find(node1);
        int parent2 = find(node2);
        
        if(parent1 == parent2) return false;
        
        parent[parent2] = parent1;
        return true;
    }
    
    static class Edge{
        int source;
        int destination;
        int length;
        
        public Edge(int source, int destination, int length){
            this.source = source;
            this.destination = destination;
            this.length = length;
        }
    }
}