import java.util.*;
import java.io.*;

public class Main{
    static List<List<Integer>> adjList;
    static int max = Integer.MIN_VALUE;
    static int N;
    static int[] nodes;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        nodes = new int[N + 1];
        adjList = new ArrayList<>();

        for(int i = 0; i <= N; i++) adjList.add(new ArrayList<>());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adjList.get(start).add(end);
        }

        for(int i = 1; i <= N; i++) bfs(i);

        for(int i = 1; i <= N; i++) max = Math.max(max, nodes[i]);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) if(nodes[i] == max) sb.append(i + " ");

        System.out.println(sb);
    }

    static void bfs(int leaf){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(leaf);

        boolean[] visited = new boolean[N + 1];
        visited[leaf] = true;

        while(!queue.isEmpty()){
            int current = queue.poll();
            
            for(int next: adjList.get(current)){
                if(!visited[next]) {
                    visited[next] = true;
                    nodes[next]++;
                    queue.offer(next);
                }
            }
        }
    }
}