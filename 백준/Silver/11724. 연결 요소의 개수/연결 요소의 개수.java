import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(reader.readLine());
        int nodes = Integer.parseInt(info.nextToken());
        int edges = Integer.parseInt(info.nextToken());
        
        int[][] adjMat = new int[nodes + 1][nodes + 1];
        
        for(int i = 0; i < edges; i++){
            StringTokenizer edgeToken = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(edgeToken.nextToken());
            int end = Integer.parseInt(edgeToken.nextToken());
            
            adjMat[start][end] = 1;
            adjMat[end][start] = 1;
        }
        
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[nodes + 1];
        int answer = 0;
        
        for(int i = 1; i < nodes + 1; i++){
            if(!visited[i]){
                int start = i;
                stack.push(start);
                while(!stack.isEmpty()){
                    int next = stack.pop();
                
                    if(visited[next]) continue;
                    visited[next] = true;
                
                    for(int j = 1; j < nodes + 1; j++){
                        if(adjMat[next][j] == 1 && !visited[j]) stack.push(j);    
                    }
                }
                answer++;
            }
        }
        
        System.out.println(answer);
    }
}