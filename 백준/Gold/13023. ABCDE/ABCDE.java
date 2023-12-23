import java.io.*;
import java.util.*;

public class Main{
    static List[] adjList;
    static boolean isTrue;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adjList = new List[N];
        for(int i = 0; i < N; i++){
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adjList[start].add(end);
            adjList[end].add(start);
        }

        visited = new boolean[N];
        isTrue = false;

        for(int i = 0; i < N; i++){
            if(!isTrue) dfs(i, 1);
        }

        System.out.println(isTrue ? 1 : 0);
    }

    static void dfs(int next, int cnt){
        if(cnt == 5){
            isTrue = true;
            return;
        }

        visited[next] = true;

        List<Integer> list = adjList[next];
        for(int node: list){
            if(!visited[node]) dfs(node, cnt + 1);
        }

        visited[next] = false;
    }
}