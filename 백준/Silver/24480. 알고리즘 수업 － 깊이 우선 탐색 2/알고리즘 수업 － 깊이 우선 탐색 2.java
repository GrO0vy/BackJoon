import java.io.*;
import java.util.*;

public class Main{
    private int[] visited;
    private List<List<Integer>> adjList;
    private int count;
    private int v;
    private int m;
    private int r;

    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        v = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>();
        for(int i = 0; i < v + 1; i++){
            adjList.add(new ArrayList<>());
        }

        visited = new int[v + 1];
        count = 1;

        for(int i = 0; i < m; i++){
            StringTokenizer mInfo = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(mInfo.nextToken());
            int y = Integer.parseInt(mInfo.nextToken());
            adjList.get(x).add(y);
            adjList.get(y).add(x);
        }

        for(int i = 1; i < v + 1; i++){
            Collections.sort(adjList.get(i), Collections.reverseOrder());
        }

        dfs(r);

        for(int i = 1; i < v + 1; i++){
            System.out.println(visited[i]);
        }
    }

    public void dfs(int next){
        visited[next] = count++;

        for(int node : adjList.get(next)){
            if(visited[node] == 0) dfs(node);
        }
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}