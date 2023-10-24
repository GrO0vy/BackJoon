import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;
        int result = 0;

        while(left < right){
            int num = arr[left] + arr[right];

            if(num == x){
                result++;
                left++;
                right--;
            }
            else if(num > x){
               right--;
            }
            else left++;
        }

        System.out.println(result);
        br.close();
    }
}