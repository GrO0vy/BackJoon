import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for(int i = 0; i < L; i++){
            String student = br.readLine();
            if(set.contains(student)) set.remove(student);
            set.add(student);
        }
        
        int cnt = 0;
        for(String student: set){
            if(cnt == K) break;
            System.out.println(student);
            cnt++;
        }
    }
}