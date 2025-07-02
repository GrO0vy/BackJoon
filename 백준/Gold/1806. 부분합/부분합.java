import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int length = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] arr = new int[length + 1];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < length; i++) arr[i] = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = 0;
        int sum = 0;
        int result = length + 1;

        while(right <= length){
            if(sum < target) sum += arr[right++];
            else {
                result = Math.min(result, right - left);
                sum -= arr[left++];
            }
        }

        System.out.println(result == length + 1 ? 0 : result);
    }
}