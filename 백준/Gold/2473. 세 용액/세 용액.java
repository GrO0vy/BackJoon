import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        long[] answer = new long[3];
        long min = Long.MAX_VALUE;

        for(int i = 0; i < N; i++){
            long selected = arr[i];

            int left = i + 1;
            int right = N - 1;

            while(left < right){
                long sum = selected + arr[left] + arr[right];
                if(Math.abs(sum) < min){
                    min = Math.abs(sum);
                    answer[0] = selected;
                    answer[1] = arr[left];
                    answer[2] = arr[right];
                }

                if(sum > 0) right--;
                else if(sum < 0) left++;
                else{
                    System.out.printf("%d %d %d",selected, arr[left], arr[right]);
                    return;
                }
            }
        }

        System.out.printf("%d %d %d", answer[0], answer[1], answer[2]);
    }
}