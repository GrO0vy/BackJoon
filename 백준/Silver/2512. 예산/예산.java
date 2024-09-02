import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        long sum = 0;
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        long result = 0;

        if(sum <= M) result = arr[N - 1];
        else{
            int left = 0;
            int right = arr[N - 1];

            while(left <= right){
                int mid = (left + right) / 2;

                long temp = 0;
                for(int i = 0; i < N; i++){
                    temp += Math.min(arr[i], mid);
                }

                if(temp > M){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }

            result = right;
        }

        System.out.println(result);
    }
}