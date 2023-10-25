import java.io.*;
import java.util.*;

public class Main{
    private static int[] arr;
    private static int K;
    private static int count = 0;
    private static int[] answer = new int[2];

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

        quickSort(0, N - 1);

        if(count < K) System.out.println(-1);
        else {
            Arrays.sort(answer);
            System.out.printf("%d %d", answer[0], answer[1]);
        }


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
        int idx = start - 1;

        for(int i = start; i < end; i++){
            if(arr[i] <= pivot) {
                int temp = arr[++idx];
                arr[idx] = arr[i];
                arr[i] = temp;
                count++;
                if(count == K) {
                    answer[0] = arr[idx];
                    answer[1] = arr[i];
                    return 0;
                }
            }
        }

        if(idx + 1 != end){
            int temp = arr[idx + 1];
            arr[idx + 1] = arr[end];
            arr[end] = temp;
            count++;
            if(count == K){
                answer[0] = arr[idx + 1];
                answer[1] = arr[end];
                return 0;
            }
        }

        return idx + 1;
    }
}