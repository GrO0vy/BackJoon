import java.util.*;
import java.io.*;

public class Main{
    static int[] arr;
    static int K;
    static int count;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, N - 1);

        if(count < K) System.out.println(-1);
    }

    static void mergeSort(int start, int end){
        if(start < end){
            int mid = ( start + end ) / 2;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);
            merge(start, mid, end);
        }
    }

    static void merge(int start, int mid, int end){
        int left = start;
        int right = mid + 1;
        int tempSize = end - start + 1;
        int[] temp = new int[tempSize];
        int idx = 0;

        while(left <= mid && right <= end){
            if(arr[left] <= arr[right]) temp[idx++] = arr[left++];
            else temp[idx++] = arr[right++];
        }

        while(left <= mid) temp[idx++] = arr[left++];
        while(right <= end) temp[idx++] = arr[right++];

        for(int i = start; i <= end; i++){
            arr[i] = temp[i - start];
            count++;
            if(count == K){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < arr.length; j++){
                    sb.append(arr[j] + " ");
                }
                System.out.println(sb.toString());
            }
        }
    }
}