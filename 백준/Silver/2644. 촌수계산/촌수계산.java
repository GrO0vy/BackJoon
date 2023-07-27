import java.util.*;
import java.io.*;

public class Main{
    private int start, end;
    private boolean[] visited;
    private List<List<Integer>> adjList;
    private int result = -1;

    public void solution() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());

        StringTokenizer compareInfo = new StringTokenizer(reader.readLine());
        start = Integer.parseInt(compareInfo.nextToken());
        end = Integer.parseInt(compareInfo.nextToken());

        int relations = Integer.parseInt(reader.readLine());

        adjList = new ArrayList<>();

        for(int i = 0; i < count + 1; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < relations; i++){
            StringTokenizer relationInfo = new StringTokenizer(reader.readLine());
            int top = Integer.parseInt(relationInfo.nextToken());
            int bottom = Integer.parseInt(relationInfo.nextToken());

            adjList.get(top).add(bottom);
            adjList.get(bottom).add(top);
        }

        visited = new boolean[count + 1];

        dfs(start, 0);

        System.out.println(result);
    }

    private void dfs(int point, int cnt){
        visited[point] = true;

        for(int next: adjList.get(point)){
            if(!visited[next]){
                if(next == end){
                    result = cnt + 1;
                    return;
                }
                dfs(next, cnt + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}