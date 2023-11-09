import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        List<Integer>[] pos = new ArrayList[200001];
        for(int i = 0; i < pos.length; i++){
            pos[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pos[100000 + x].add(y);
        }
        
        for(int i = 0; i < pos.length; i++){
            Collections.sort(pos[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < pos.length; i++){
            List<Integer> list = pos[i];
            for(int posY: list){
                sb.append(i - 100000 + " " + posY + "\n");    
            }
        }
        
        System.out.println(sb);
    }
}