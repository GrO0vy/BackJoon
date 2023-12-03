import java.util.*;
import java.io.*;

public class Main{
    static boolean flag;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static int[] check;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        for(int i = 0; i < K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            visited = new boolean[V + 1];
            adjList = new ArrayList[V + 1];
            check = new int[V + 1];
            flag = true;

            for(int j = 1; j < adjList.length; j++){
                adjList[j] = new ArrayList<>();
            }

            for(int j = 0; j < E; j++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                adjList[start].add(end);
                adjList[end].add(start);
            }

            for(int j = 1; j < V + 1; j++){
                if(!flag) break;
                if(!visited[j]) dfs(j);
            }

            System.out.println(flag ? "YES": "NO");
        }
    }

    static void dfs(int vertex){
        List<Integer> list = adjList[vertex];
        visited[vertex] = true;

        for(int destination: list){
            if(!visited[destination]){
                check[destination] = (check[vertex] + 1) % 2;
                dfs(destination);
            }
            else{
                if(check[vertex] == check[destination]){
                    flag = false;
                    return;
                }
            }
        }
    }
}