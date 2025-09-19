import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int[][] costs;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        costs = new int[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) costs[i][j] = Integer.parseInt(st.nextToken());
        }

        System.out.println(findMinCost());
    }

    static long findMinCost(){
        long minCost = 0;

        int[] parent = new int[N];
        for(int i = 0; i < N; i++) parent[i] = i;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> costs[o1[0]][o1[1]] - costs[o2[0]][o2[1]]);
        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N; j++){
                pq.offer(new int[]{i, j});
            }
        }

        while(!pq.isEmpty()){
            int[] flow = pq.poll();

            if(find(flow[0], parent) != find(flow[1], parent)){
                union(parent[flow[0]], parent[flow[1]], parent);
                minCost += costs[flow[0]][flow[1]];
            }
        }

        return minCost;
    }

    static void union(int root1, int root2, int[] parent){
        parent[root2] = root1;
    }

    static int find(int node, int[] parent){
        if(parent[node] == node) return node;
        return parent[node] = find(parent[node], parent);
    }
}