import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] cnt = new int[100001];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int left = 0;
        int result = 0;

        for(int i = 0; i < N; i++){
            cnt[arr[i]]++;

            while(left < i && cnt[arr[i]] > K){
                cnt[arr[left]]--;
                left++;
            }

            result = Math.max(result, i - left + 1);
        }

        System.out.println(result);
    }
}