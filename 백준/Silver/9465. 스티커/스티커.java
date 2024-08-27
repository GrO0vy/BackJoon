import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n + 1];
            int[][] sumArr = new int[2][n + 1];
            
            
            for(int j = 0; j < 2; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k = 1; k <= n; k++){
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }    
            }
            
            sumArr[0][1] = arr[0][1];
            sumArr[1][1] = arr[1][1];
            
            for(int k = 2; k <= n; k++){
                sumArr[0][k] = Math.max(sumArr[1][k - 1], Math.max(sumArr[0][k - 2], sumArr[1][k - 2])) + arr[0][k];
                sumArr[1][k] = Math.max(sumArr[0][k - 1], Math.max(sumArr[0][k - 2], sumArr[1][k - 2])) + arr[1][k];
            }
            
            sb.append(Math.max(sumArr[0][n], sumArr[1][n]) + "\n");
        }
        
        System.out.println(sb);
    }
}