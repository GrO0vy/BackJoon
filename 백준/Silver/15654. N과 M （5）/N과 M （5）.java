import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int M;
    static int[] numbers;
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        numbers = new int[N];
        visited = new boolean[N];
        arr = new int[M];

        for(int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(numbers);

        searchSequence(0);

        System.out.println(sb);
    }

    static void searchSequence(int len){
        if(len == M){
            for(int i = 0; i < M; i++) sb.append(arr[i] + " ");
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++){
            if(!visited[i]){
                arr[len] = numbers[i];
                visited[i] = true;
                searchSequence(len + 1);
                visited[i] = false;
            }
        }
    }
}