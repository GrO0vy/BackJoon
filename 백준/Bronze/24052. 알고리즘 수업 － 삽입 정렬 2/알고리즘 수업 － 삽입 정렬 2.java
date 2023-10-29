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
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        for(int i = 1; i < N; i++) {
            int j = i - 1;
            int item = arr[i];

            while (j >= 0 && arr[j] > item) {
                arr[j + 1] = arr[j];
                j--;
                count++;
                if(count == K){
                    for(int k = 0; k < N; k++){
                        System.out.print(arr[k] + " ");
                    }
                    return;
                }
            }
            if(j + 1 != i) {
                arr[j + 1] = item;
                count++;
                if(count == K){
                    for(int k = 0; k < N; k++){
                        System.out.print(arr[k] + " ");
                    }
                    return;
                }
            }
        }

        System.out.println(-1);
        br.close();
    }
}