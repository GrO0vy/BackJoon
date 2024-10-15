import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] arr = new long[k + 1];

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());

            for(int j = 1; j <= k; j++){
                if(arr[j] > 0 && j + num <= k) arr[j + num] += arr[j];
                if(j % num == 0) arr[j]++;
            }
        }
        
        System.out.println(arr[k]);
    }
}