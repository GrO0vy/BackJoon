import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            map.put(Integer.parseInt(st.nextToken()), 1);
        }
        
        int M = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < M; i++){
            int num = map.getOrDefault(Integer.parseInt(st.nextToken()), 0);
            sb.append(num + " ");
        }
        
        System.out.println(sb);
    }
}