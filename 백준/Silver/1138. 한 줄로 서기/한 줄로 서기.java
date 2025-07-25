import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        List<Integer> result = new ArrayList<>();
        for(int i = N - 1; i >= 0; i--) result.add(arr[i], i + 1);
        
        StringBuilder sb = new StringBuilder();
        for(int person: result) sb.append(person + " ");
        
        System.out.println(sb);
    }
}