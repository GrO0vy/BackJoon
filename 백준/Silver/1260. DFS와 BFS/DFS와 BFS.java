import java.io.*;
import java.util.*;

public class Main{
    static List<Integer>[] adjList;
    static StringBuilder sb;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        adjList = new List[N + 1];
        for(int i = 1; i <=N; i++){
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adjList[start].add(end);
            adjList[end].add(start);
        }

        for(int i = 1; i <= N; i++){
            Collections.sort(adjList[i]);
        }

        sb = new StringBuilder();
        dfs(V, new boolean[N + 1]);
        sb.append("\n");
        bfs(V, new boolean[N + 1]);

        System.out.println(sb);
    }

    static void bfs(int node, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            int current = queue.poll();
            if(visited[current]) continue;

            visited[current] = true;
            sb.append(current + " ");

            for(int next: adjList[current]){
                if(!visited[next]) queue.offer(next);
            }
        }
    }

    static void dfs(int node, boolean[] visited){
        visited[node] = true;
        sb.append(node + " ");
        for(int next: adjList[node]){
            if(!visited[next]) dfs(next, visited);
        }
    }
}