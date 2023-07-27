import java.io.*;
import java.util.*;

public class Main{
    public void solution() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        int[] parent = new int[count + 1];
        
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i = 0; i < count + 1; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int i = 0; i < count - 1; i++){
            StringTokenizer linkInfo = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(linkInfo.nextToken());
            int end = Integer.parseInt(linkInfo.nextToken());
            
            adjList.get(start).add(end);
            adjList.get(end).add(start);
        }
        
        boolean[] visited = new boolean[count + 1];
        
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        
        while(!stack.isEmpty()){
            int next = stack.pop();
            
            if(visited[next]) continue;
            
            visited[next] = true;
            
            for(int child: adjList.get(next)){
                if(!visited[child]){
                    stack.push(child);
                    parent[child] = next;
                }
            }    
        }
        
        for(int i = 2; i < count + 1; i++){
            System.out.println(parent[i]);
        }
    }
    
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}