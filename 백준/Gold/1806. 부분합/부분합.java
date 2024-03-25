import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;

        while(left <= N && right <= N){
            if(sum >= S) {
                result = Math.min(result, right - left);
                sum -= arr[left++];
            }
            else sum += arr[right++];
        }

        System.out.println(result == Integer.MAX_VALUE ? 0 : result);
    }
}