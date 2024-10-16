import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int women = Integer.parseInt(st.nextToken());
        int men = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int team = 0;
        while(true){
            women -= 2;
            men--;
            
            if(women < 0 || men < 0 || women + men < K) break;
            
            team++;
        }
        
        System.out.println(team);
    }
}