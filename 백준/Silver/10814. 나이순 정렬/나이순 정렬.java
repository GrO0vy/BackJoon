import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        List<String>[] users = new ArrayList[201];
        for(int i = 0; i < 201; i++){
            users[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            
            users[age].add(name);    
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < users.length; i++){
            List<String> user = users[i];
            for(int j = 0; j < user.size(); j++){
                sb.append(i + " " + user.get(j) + "\n");
            }
        }
        
        System.out.println(sb);
    }
}