import java.util.*;
import java.io.*;

public class Main{
    private static int[] arr;
    private static int K;
    private static int N;
    private static int count;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        count = 0;
        quickSort(0, N - 1);

        if(count < K) System.out.println(-1);
    }

    static void quickSort(int start, int end){
        if(start < end){
            int mid = partition(start, end);
            quickSort(start, mid - 1);
            quickSort(mid + 1, end);
        }
    }

    static int partition(int start, int end){
        int pivot = arr[end];
        int i = start - 1;

        for(int j = start; j < end; j++){
            if(arr[j] <= pivot){
                int temp = arr[++i];
                arr[i] = arr[j];
                arr[j] = temp;
                count++;
                if(count == K){
                    for(int k = 0; k < N; k++){
                        System.out.print(arr[k] + " ");
                    }
                }
            }
        }
        if(i + 1 != end){
            int temp = arr[i + 1];
            arr[i + 1] = arr[end];
            arr[end] = temp;
            count++;
            if(count == K){
                for(int k = 0; k < N; k++){
                    System.out.print(arr[k] + " ");
                }
            }
        }
        return i + 1;
    }  
}