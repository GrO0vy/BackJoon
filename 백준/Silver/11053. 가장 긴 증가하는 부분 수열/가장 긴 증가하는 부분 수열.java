import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N + 1];
        int[] D = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++){
            for(int j = 0; j <= i - 1; j++){
                if(A[i] > A[j]) D[i] = Math.max(D[i], D[j] + 1);
            }
        }

        int result = 0;
        for(int i = 1; i <= N; i++){
            result = Math.max(result, D[i]);
        }

        System.out.println(result);
    }
}