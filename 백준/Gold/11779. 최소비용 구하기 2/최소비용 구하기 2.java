import java.util.*;
import java.io.*;

public class Main{
    static List<List<Bus>> adjList;
    static int[] parent;
    static int[] costs;
    static List<Integer> path;
    static StringBuilder sb;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        sb = new StringBuilder();
        path = new ArrayList<>();

        adjList = new ArrayList<>();
        for(int i = 0; i <= n; i++) adjList.add(new ArrayList<>());

        costs = new int[n + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        parent = new int[n + 1];
        for(int i = 1; i <= n; i++) parent[i] = i;

        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adjList.get(node1).add(new Bus(node2, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        sb.append(search(start, end) +"\n");
        sb.append(getNodes(end) + "\n");
        for(int node: path) sb.append(node + " ");

        System.out.println(sb.toString());
    }

    static int search(int start, int end){
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> costs[o1] - costs[o2]);
        costs[start] = 0;
        pq.offer(start);

        while(!pq.isEmpty()){
            int current = pq.poll();
            
            if(visited[current]) continue;
            visited[current] = true;
            
            for(Bus bus: adjList.get(current)){
                int nextCost = costs[current] + bus.cost;

                if(nextCost < costs[bus.destination]){
                    costs[bus.destination] = nextCost;
                    parent[bus.destination] = current;
                    pq.offer(bus.destination);
                }
            }
        }

        return costs[end];
    }

    static int getNodes(int node){
        path.add(0, node);

        if(parent[node] == node){
            return 1;
        }

        return getNodes(parent[node]) + 1;
    }

    static class Bus{
        int destination;
        int cost;

        public Bus(int destination, int cost){
            this.destination = destination;
            this.cost = cost;
        }
    }
}