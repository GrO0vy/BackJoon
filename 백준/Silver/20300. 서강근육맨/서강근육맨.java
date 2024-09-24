import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) arr[i] = Long.parseLong(st.nextToken());

        Arrays.sort(arr);

        long result = arr[N - 1];

        int start = 0;
        int end = N - 1;
        if(N % 2 == 1) end--;

        while(start < end){
            result = Math.max(result, arr[start++] + arr[end--]);
        }

        System.out.println(result);
    }
}