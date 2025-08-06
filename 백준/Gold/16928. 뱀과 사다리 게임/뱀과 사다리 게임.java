import java.io.*;
import java.util.*;

public class Main{
    static final int MAP_SIZE = 101;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] map = new int[MAP_SIZE];
        int[] visited = new int[MAP_SIZE];
        
        for(int i = 1; i < MAP_SIZE; i++) map[i] = i;
        
        for(int i = 0; i < N + M; i++){
            String[] input = br.readLine().split(" ");
            
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            
            map[start] = end;
        }
        
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        
        while(!queue.isEmpty()){
            int current = queue.poll();
            
            for(int i = 1; i <= 6; i++){
                int next = map[current + i];
                if(next < MAP_SIZE && visited[next] == 0){
                    visited[next] = visited[current] + 1;
                    if(next == 100){
                        System.out.println(visited[next]);
                        return;
                    }
                    queue.offer(next);
                }
            }
        }
    }
}