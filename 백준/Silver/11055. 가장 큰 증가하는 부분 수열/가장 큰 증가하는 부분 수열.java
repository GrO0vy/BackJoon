import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int[] arr = new int[A + 1];
        int[] dp = new int[A + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= A; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i <= A; i++){
            for(int j = i - 1; j >= 0; j--){
                if(arr[j] < arr[i]) dp[i] = Math.max(dp[i], dp[j] + arr[i]);
            }
        }
        
        int result = 0;
        for(int i = 1; i <= A; i++){
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}