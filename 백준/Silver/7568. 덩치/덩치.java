import java.io.*;
import java.util.*;

public class Main{
public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    
    int[][] size = new int[N][2];
    for(int i = 0; i < N; i++){
        String[] input = br.readLine().split(" ");
        size[i][0] = Integer.parseInt(input[0]);
        size[i][1] = Integer.parseInt(input[1]);
    }
    
    StringBuilder sb = new StringBuilder();
    
    for(int i = 0; i < N; i++){
        int[] p1 = size[i];
        int rank = 1;
        
        for(int j = 0; j < N; j++){
            if(i == j) continue;
            
            int[] p2 = size[j];
            if(p1[0] < p2[0] && p1[1] < p2[1]) rank++;
        }
        
        sb.append(rank + " ");
    }
    
    System.out.println(sb.toString());
}
}