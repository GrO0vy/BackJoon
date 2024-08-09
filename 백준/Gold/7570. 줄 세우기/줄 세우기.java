import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        
        int max = -1;
        for(int i = 0; i < N; i++){
            int student = Integer.parseInt(st.nextToken());
            arr[student] = arr[student - 1] + 1;
            max = Math.max(max, arr[student]);
        }
        
        System.out.println(N - max);     
    }
}