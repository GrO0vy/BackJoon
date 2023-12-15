import java.io.*;
import java.util.StringTokenizer;

public class Main{
        public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] cnt = new int[M];

        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            sum = (sum + Integer.parseInt(st.nextToken())) % M;
            cnt[sum]++;
        }

        long result = cnt[0];
        for(int i = 0; i < M; i++){
            result += (long)cnt[i] * (cnt[i] - 1) / 2;
        }

        System.out.println(result);
    }
}