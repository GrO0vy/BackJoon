import java.util.*;
import java.io.*;

public class Main{
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        for(int i = 1; i <=n; i++){
            arr[i] = i;
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(op == 0) union(find(a), b);
            else{
                System.out.println(find(a) == find(b) ? "YES" : "NO");
            }
        }
    }

    static int find(int num){
        int result = num;
        if(arr[num] != num) result = find(arr[num]);
        return result;
    }

    static void union(int a, int b){
        if(arr[b] != b) union(a, arr[b]);
        arr[b] = a;
    }
}