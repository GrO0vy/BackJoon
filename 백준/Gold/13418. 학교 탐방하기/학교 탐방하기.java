import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static List<Edge> edges;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        edges = new ArrayList<>();

        for(int i = 0; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int kind = Integer.parseInt(st.nextToken());
            kind = kind == 0 ? 1 : 0;
            
            edges.add(new Edge(node1, node2, kind));
        }
        
        PriorityQueue<Edge> asc = new PriorityQueue<>((o1, o2) -> o1.kind - o2.kind);
        PriorityQueue<Edge> desc = new PriorityQueue<>((o1, o2) -> o2.kind - o1.kind);

        System.out.println(getTiredness(desc) - getTiredness(asc));
    }
    
    static int getTiredness(PriorityQueue<Edge> pq){
        for(Edge edge: edges) pq.offer(edge);
        
        int[] parent = new int[N + 1];
        for(int i = 1; i <= N; i++) parent[i] = i;
        
        int tiredness = 0;
        
        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            
            if(union(edge.start, edge.destination, parent)){
                tiredness += edge.kind;
            }
        }
        
        return (int) Math.pow(tiredness, 2);
    }
    
    static boolean union(int node1, int node2, int[] parent){
        int parent1 = find(node1, parent);
        int parent2 = find(node2, parent);
        
        if(parent1 == parent2) return false;
        
        parent[parent2] = parent1;
        return true;
    }
    
    static int find(int node, int[] parent){
        if(parent[node] == node) return node;
        
        return parent[node] = find(parent[node], parent);
    }
    
    static class Edge{
        int start;
        int destination;
        int kind;
        
        public Edge(int start, int destination, int kind){
            this.start = start;
            this.destination = destination;
            this.kind = kind;
        }
    }
}