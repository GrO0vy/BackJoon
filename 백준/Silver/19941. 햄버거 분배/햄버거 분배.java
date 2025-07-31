import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[N];

        String table = br.readLine();
        int result = 0;

        for(int i = 0; i < N; i++){
            if(table.charAt(i) == 'P'){
                for(int j = i - K; j <= i + K; j++){
                    if(j < 0 || j >= N) continue;
                    
                    if(table.charAt(j) == 'H' && !visited[j]){
                        visited[j] = true;
                        result++;
                        break;
                    }
                }
            }
        }

        System.out.println(result);
    }
}