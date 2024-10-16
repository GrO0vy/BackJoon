import java.io.*;
import java.util.*;

public class Main{
    static StringBuilder sb;
    static int N;
    static int M;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr= new int[M];
        sb = new StringBuilder();

        searchSequence(0);

        System.out.println(sb);
    }

    static void searchSequence(int depth){
        if(depth == M){
            for(int i = 0; i < M; i++){
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++){
            arr[depth] = i;
            searchSequence(depth + 1);
        }
    }
}