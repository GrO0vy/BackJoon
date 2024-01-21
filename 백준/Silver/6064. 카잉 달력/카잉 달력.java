import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            int last = M * N / gcd(M, N);
            int year = x;
            
            while(true){
                if(year > last){
                    sb.append(-1 + "\n");
                    break;
                }
                
                int nextY = year % N == 0 ? N : year % N;
                if(nextY == y){
                    sb.append(year + "\n");
                    break;
                }
                
                year += M;
            }
        }
        System.out.println(sb);
    }
    
    static int gcd(int M, int N){
        if(N == 0) return M;
        return gcd(N, M%N);
    }
}