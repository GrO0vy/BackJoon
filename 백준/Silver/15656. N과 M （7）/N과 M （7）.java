import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int M;
    static int[] numbers;
    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();
        numbers = new int[N];
        arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        searchSequence(0);

        System.out.println(sb);
    }

    static void searchSequence(int len){
        if(len == M){
            for(int i = 0; i < M; i++){
                sb.append(arr[i] + " ");
            }
            sb.append("\n");

            return;
        }

        for(int i = 0; i < N; i++){
            arr[len] = numbers[i];
            searchSequence(len + 1);
        }
    }
}