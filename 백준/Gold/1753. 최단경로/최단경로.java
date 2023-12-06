import java.util.*;
import java.io.*;

public class Main{
    static ArrayList<int[]>[] adjList;
    static int[] minDistance;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        visited = new boolean[V + 1];

        minDistance = new int[V + 1];
        for(int i = 1; i <= V; i++) {
            if(i == start) minDistance[i] = 0;
            else minDistance[i] = Integer.MAX_VALUE;
        }

        adjList = new ArrayList[V + 1];
        for(int i = 0; i <= V; i++) adjList[i] = new ArrayList<>();

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjList[from].add(new int[]{to, weight});
        }

        search(start);

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= V; i++){
            if(minDistance[i] == Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(minDistance[i]).append("\n");
        }

        System.out.print(sb);
    }

    static void search(int x){
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> {
            return o1[1] - o2[1];
        }));

        pq.offer(new int[]{x, 0});

        while(!pq.isEmpty()){
            int[] info = pq.poll();
            
            if(visited[info[0]]) continue;
            
            visited[info[0]] = true;
            
            for(int[] ver: adjList[info[0]]){
                int vertex = ver[0];
                int weight = ver[1];

                if(minDistance[info[0]] + weight < minDistance[vertex]){
                    minDistance[vertex] = minDistance[info[0]] + weight;
                    pq.offer(new int[]{vertex, minDistance[vertex]});
                }
            }
        }
    }
}