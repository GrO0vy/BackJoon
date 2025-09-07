import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int[] parent;
    static int[][] connectCosts;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        connectCosts = new int[N + 1][N + 1];
        parent = new int[N + 1];
        
        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }
        
        for(int i = 1; i <= N; i++){
            connectCosts[0][i] = Integer.parseInt(br.readLine());    
        }
        
        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                connectCosts[i][j] = Integer.parseInt(st.nextToken());    
            }
        }
        
        PriorityQueue<int[]> edges = new PriorityQueue<>((o1, o2) -> connectCosts[o1[0]][o1[1]] - connectCosts[o2[0]][o2[1]]);
        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= N; j++){
                if(connectCosts[i][j] > 0) edges.offer(new int[]{i, j});
            }
        }
        
        int totalCost = 0;
        while(!edges.isEmpty()){
            int[] edge = edges.poll();
            
            if(find(edge[0]) != find(edge[1])){
                totalCost += connectCosts[edge[0]][edge[1]];
                union(edge[0], edge[1]);
            }
        }
        
        System.out.println(totalCost);
    }
    
    static int find(int node){
        if(parent[node] == node) return node;
        
        return parent[node] = find(parent[node]);
    }
    
    static void union(int node1, int node2){
        int parent1 = find(node1);
        int parent2 = find(node2);
        
        if(parent1 != parent2){
            parent[parent2] = parent1;
        }
    }
}