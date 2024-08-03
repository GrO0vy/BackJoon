import java.util.*;
import java.io.*;

public class Main{
    static int[] arr;

    public static void main(String[] args)  throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i< N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;
        int result = Integer.MAX_VALUE;

        while(left < right){
            int sum = arr[left] + arr[right];
            if(Math.abs(sum) < Math.abs(result)) result = sum;

            if(sum < 0) left++;
            else if(sum > 0) right--;
            else {
                result = sum;
                break;
            }
        }

        System.out.println(result);
    }
}