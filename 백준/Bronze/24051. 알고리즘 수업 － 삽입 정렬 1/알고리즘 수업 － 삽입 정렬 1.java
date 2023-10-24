import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());


        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        int count = 0;
        int result = -1;

        for(int i = 1; i < N; i++){
            int idx = i;
            int value = arr[idx];

            for(int j = i - 1; j >= 0; j--){
                if(arr[i] < arr[j]) idx = j;
            }

            for(int j = i; j > idx; j--){
                arr[j] = arr[j - 1];
                count++;
                if(count == K){
                    result = arr[j - 1];
                    break;
                }
            }
            
            if(idx != i) {
                arr[idx] = value;
                count++;
            }
            
            if(count == K){
                result = arr[idx];
                break;
            }
        }

        System.out.println(result);
        
        br.close();
    }
}