import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int M;
    static int[] numbers;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        for(int i = 0; i < N; i++){
            int[] selected = new int[M];
            selected[0] = numbers[i];

            search(i, selected, 1);
        }

        System.out.println(sb.toString());
    }

    static void search(int start, int[] selected, int cnt){
        if(cnt == M){
            for(int i = 0; i < M; i++){
                sb.append(selected[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i < N; i++){
            selected[cnt] = numbers[i];
            search(i, selected, cnt + 1);
        }
    }
}