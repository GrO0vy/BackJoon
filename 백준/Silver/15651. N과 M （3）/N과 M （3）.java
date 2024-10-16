import java.io.*;
import java.util.*;

public class Main{
    static StringBuilder sb;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();

        searchSequence("", 0, N, M);

        System.out.println(sb);
    }

    static void searchSequence(String sequence, int cnt, int N, int M){
        if(cnt == M){
            sb.append(sequence.trim() + "\n");
            return;
        }

        for(int i = 1; i <= N; i++){
            searchSequence(sequence + " " + i, cnt + 1, N, M);
        }
    }
}