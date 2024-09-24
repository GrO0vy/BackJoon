import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();

        recur("", 0, 0, N, M);

        System.out.println(sb);
    }

    static void recur(String str, int num, int len, int N, int M){
        if(len == M) {
            sb.append(str.trim() + "\n");
            return;
        }

        for(int i = 1; i <= N; i++){
            if(i <= num % 10) continue;
            recur(String.format("%s %d", str, i), num * 10 + i, len + 1, N, M);
        }
    }
}