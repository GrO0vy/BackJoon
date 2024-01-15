import java.io.*;
import java.util.*;

public class Main{
    static StringBuilder sb;
    static int N;
    static int M;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isVisited = new boolean[N + 1];
        sb = new StringBuilder();

        solution(0, "");
        System.out.println(sb);
    }

    static void solution(int cnt, String result){
        if(M == cnt){
            sb.append(result + "\n");
        }
        else{
            for(int i = 1; i <= N; i++){
                if(!isVisited[i]) {
                    isVisited[i] = true;
                    solution(cnt + 1, result + i + " ");
                    isVisited[i] = false;
                }
            }
        }
    }
}