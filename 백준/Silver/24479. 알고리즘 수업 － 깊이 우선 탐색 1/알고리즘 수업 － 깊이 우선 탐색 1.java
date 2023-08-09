import java.util.*;
import java.io.*;

public class Main{
    boolean[] visited;
    List<List<Integer>> adjList;
    int vertexCount;
    int count = 1;
    int[] answer;

    public void solution() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(reader.readLine());

        vertexCount = Integer.parseInt(info.nextToken());
        int edgeCount = Integer.parseInt(info.nextToken());
        int start = Integer.parseInt(info.nextToken());

        visited = new boolean[vertexCount + 1];
        adjList = new ArrayList<>();

        for(int i = 0; i < vertexCount + 1; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < edgeCount; i++){
            StringTokenizer edgeInfo = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(edgeInfo.nextToken());
            int to = Integer.parseInt(edgeInfo.nextToken());

            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }

        for(List<Integer> row: adjList){
            Collections.sort(row);
        }

        answer = new int[vertexCount + 1];
        dfs(start);
        for(int i = 1; i < vertexCount + 1; i++){
            System.out.println(answer[i]);
        }
    }

    private void dfs(int next){
        visited[next] = true;
        answer[next] = count;

        for(int to: adjList.get(next)){
            if(!visited[to]) {
                count++;
                dfs(to);
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}