import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        if(N == 0){
            System.out.println(1);
            return;
        }
        
        int score  = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] ranking = new int[P];
        Arrays.fill(ranking, -1);

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) ranking[i] = Integer.parseInt(st.nextToken());

        int rank = -1;

        for(int i = 0; i < P; i++){
            if(score >= ranking[i]){
                rank = i + 1;
                break;
            }
        }

        int idx = P;

        for(int i = P - 1; i >= 0; i--){
            if(ranking[i] >= score) break;
            idx--;
        }

        System.out.println(idx < P ? rank : -1);
    }
}