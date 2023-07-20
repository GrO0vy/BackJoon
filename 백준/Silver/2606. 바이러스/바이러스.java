import java.util.*;
import java.io.*;

public class Main{
    public void solution() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        int edges = Integer.parseInt(reader.readLine());
        
        int[][] adjMat = new int[count + 1][count + 1];
        boolean[] isInfected = new boolean[count + 1];
            
        for(int i = 0; i < edges; i++){
            StringTokenizer edgeInfo = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(edgeInfo.nextToken());
            int end = Integer.parseInt(edgeInfo.nextToken());
            
            adjMat[start][end] = 1;
            adjMat[end][start] = 1;
        }
        
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        
        int answer = 0;
        
        while(!stack.isEmpty()){
            int next = stack.pop();
            
            if(isInfected[next]) continue; 
            
            isInfected[next] = true;
            
            for(int i = 1; i < count + 1; i++){
                if(adjMat[next][i] == 1 && !isInfected[i]) stack.push(i);
            }
        }
        
        for(int i = 2; i < count + 1; i++){
            if(isInfected[i]) answer++;
        }
        
        System.out.println(answer);
    }
    
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}