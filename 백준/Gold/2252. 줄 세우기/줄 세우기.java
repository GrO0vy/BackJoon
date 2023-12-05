import java.util.*;
import java.io.*;

public class Main{
    static ArrayList<Integer>[] adjList;
    static int[] degree;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] adjList = new ArrayList[N + 1];
        int[] degree = new int[N + 1];
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= N; i++){
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adjList[start].add(end);
            degree[end] += 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            if(degree[i] == 0) queue.offer(i);
        }
        
        while(!queue.isEmpty()){
            int vertex = queue.poll();
            sb.append(vertex).append(" ");
            
            for(int v: adjList[vertex]) {
                degree[v] -= 1;
                if(degree[v] == 0) queue.offer(v);
            }     
        }
        
        System.out.println(sb);
    }
}