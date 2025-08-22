import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Set<String> memo = new HashSet<>();
        for(int i = 0; i < N; i++){
            memo.add(br.readLine());
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            String[] keywords = br.readLine().split(",");
            
            for(String keyword: keywords){
                if(memo.contains(keyword)){
                    memo.remove(keyword);
                }
            }
            
            sb.append(memo.size() + "\n");
        }
        
        
        System.out.println(sb.toString());
    }
}