import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = 0;
        int odd = 0;
        int result = 0;

        while(right < N){
            if(odd < K){
                if(arr[right] % 2 == 1) odd++;
                right++;
                result = Math.max(result, right - left - odd);
            }
            else if(arr[right] % 2 == 0){
                right++;
                result = Math.max(result, right - left - odd);
            }
            else{
                if(arr[left] % 2 == 1) odd--;
                left++;
            }
        }

        System.out.println(result);
    }
}