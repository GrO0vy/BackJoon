import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] result = new int[2];
        int min = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N - 1;

        while(left < right){
            int value = arr[left] + arr[right];
            if(Math.abs(value) < min){
                result[0] = arr[left];
                result[1] = arr[right];
                min = Math.abs(value);
            }

            if(value < 0) left++;
            else if(value > 0) right--;
            else break;
        }

        System.out.println(result[0] + " " + result[1]);
    }
}