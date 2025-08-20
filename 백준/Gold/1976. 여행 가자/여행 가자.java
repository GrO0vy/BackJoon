import java.io.*;
import java.util.*;

public class Main{
    static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        parent = new int[N + 1];
        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }
        
        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                int isConnected = Integer.parseInt(st.nextToken());
                
                if(isConnected == 1){
                    union(i, j);
                }
            }
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        
        for(int i = 1; i < M; i++){
            if(find(start) != find(Integer.parseInt(st.nextToken()))){
                System.out.println("NO");
                return;
            }        
        }
        
        System.out.println("YES");
    }
    
    static void union(int x,int y){
        int parentX = find(x);
        int parentY = find(y);
        
        if(parentX > parentY){
            parent[parentX] = parentY;            
        }
        else parent[parentY] = parentX;
    }
    
    static int find(int x){
        if(parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }
}