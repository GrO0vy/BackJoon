import java.util.*;
import java.io.*;

public class Main{
    static int[] arr;
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        arr = new int[N + 2];
        arr[0] = 0;

        if(L > 0){
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
        }

        arr[N + 1] = L;

        Arrays.sort(arr);

        int left = 1;
        int right = L - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            int cnt = count(mid);

            if(cnt > M){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        System.out.println(left);
    }

    static int count(int dist){
        int cnt = 0;
        for(int i = 1; i < N + 2; i++){
            cnt += (arr[i] - arr[i - 1] - 1) / dist;
        }

        return cnt;
    }
}