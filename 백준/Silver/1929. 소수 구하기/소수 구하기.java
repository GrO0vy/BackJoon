import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N + 1];
        for(int i = 2; i <= N; i++){
            numbers[i] = i;
        }

        for(int i = 2; i <= Math.sqrt(N); i++){
            for(int j = i * i; j <= N; j += i){
                if(numbers[j] == 0) continue;
                numbers[j] = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = M; i <= N; i++) if(numbers[i] != 0) sb.append(i + "\n");
        System.out.println(sb);
    }
}