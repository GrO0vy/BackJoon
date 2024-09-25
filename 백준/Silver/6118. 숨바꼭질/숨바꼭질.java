import java.io.*;
import java.util.*;

public class Main{
    static List<Integer> result;
    static List<List<Integer>> adjList;
    static int max = -1;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        result = new ArrayList<>();

        adjList = new ArrayList<>();
        for(int i = 0; i <= N; i++) adjList.add(new ArrayList<>());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            adjList.get(node1).add(node2);
            adjList.get(node2).add(node1);
        }

        search(new boolean[N + 1]);

        Collections.sort(result);

        System.out.printf("%d %d %d", result.get(0), max, result.size());
    }

    static void search(boolean[] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {1, 0});
        visited[1] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int node = cur[0];
            int distance = cur[1];

            if(distance > max){
                result = new ArrayList<>();
                result.add(node);
                max = distance;
            }
            else if(distance == max) result.add(node);

            for(int next: adjList.get(node)){
                if(!visited[next]){
                    queue.offer(new int[]{next, distance + 1});
                    visited[next] = true;
                }
            }
        }
    }
}