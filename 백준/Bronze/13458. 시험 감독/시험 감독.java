import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long result = 0;
        for(int i = 0; i < N; i++){
            int cnt = 1;
            arr[i] -= B;

            if(arr[i] > 0){
                cnt += arr[i] / C;
                if(arr[i] % C > 0) cnt++;
            }

            result += cnt;
        }

        System.out.println(result);
    }
}