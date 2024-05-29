import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] cnt = new int[d + 1];
        cnt[c]++;

        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());

        int left = 0;
        int right = 0;
        int combo = 0;
        int kind = 1;
        int result = 0;

        while(left < N){
            if(combo < k){
                if(cnt[arr[right]] == 0) kind++;
                cnt[arr[right]]++;
                combo++;
                right = (right + 1) % N;
                result = Math.max(result, kind);
            }
            else{
                cnt[arr[left]]--;
                if(cnt[arr[left]] == 0) kind--;
                combo--;
                left++;
            }
        }

        System.out.println(result);
    }
}