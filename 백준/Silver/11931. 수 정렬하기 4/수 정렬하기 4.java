import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        boolean[] arr = new boolean[2000001];
        
        for(int i = 0; i < N; i++){
            arr[1000000 + Integer.parseInt(br.readLine())] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = arr.length - 1; i >= 0; i--){
            if(arr[i]) sb.append(i - 1000000).append("\n");
        }
        
        System.out.println(sb);
    }
}