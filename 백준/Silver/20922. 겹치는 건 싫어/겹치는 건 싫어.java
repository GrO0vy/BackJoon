import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] cntNum = new int[100001];
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = 0;
        int answer = 0;

        while(right < N){
            if(cntNum[arr[right]] == K){
                answer = Math.max(answer, right - left);
                while(true) {
                    if(arr[left] == arr[right]){
                        cntNum[arr[left]]--;
                        left++;
                        break;
                    }
                    cntNum[arr[left]]--;
                    left++;
                }
            }

            cntNum[arr[right]]++;
            right++;
        }

        answer = Math.max(answer, right - left);

        System.out.println(answer);
    }
}