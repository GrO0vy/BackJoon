import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] cnt = new int[100001];
        int[] arr = new int[N + 2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int left = 1;
        int right = 1;
        long answer = 0;

        while(left <= N){
            while(right <= N && cnt[arr[right]] == 0){
                cnt[arr[right]]++;
                right++;
            }

            answer += right - left;
            cnt[arr[left]]--;
            left++;
        }

        System.out.println(answer);
    }
}