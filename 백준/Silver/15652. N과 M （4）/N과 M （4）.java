import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int M;
    static int[] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        arr = new int[M];

        searchSequence(0, 0);

        System.out.println(sb);
    }

    static void searchSequence(int len, int recent){
        if(len == M){
            for(int i = 0; i < M; i++){
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++){
            if(i < recent) continue;
            arr[len] = i;
            searchSequence(len + 1, arr[len]);
        }
    }
}