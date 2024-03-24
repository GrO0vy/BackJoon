import java.io.*;
import java.util.*;

public class Main{
    static int cnt = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < arr.length; i++){
            search(arr, i, 0, S);
        }

        System.out.println(cnt);
    }

    static void search(int[] arr, int idx, int sum, int target){
        sum += arr[idx];
        if(sum == target) cnt++;

        for(int i = idx + 1; i < arr.length; i++)
            search(arr, i, sum, target);
    }
}