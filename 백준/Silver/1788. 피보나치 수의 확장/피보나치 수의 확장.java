import java.io.*;
import java.util.*;

public class Main{
    static final int MOD = 1000000000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[Math.abs(n) + 2];
        arr[0] = 0;
        arr[1] = 1;

        if(n > 0){
            for(int i = 2; i <= Math.abs(n); i++){
                arr[i] = (arr[i - 1] + arr[i - 2]) % MOD;
            }
        }
        else{
            for(int i = 2; i <= Math.abs(n); i++){
                arr[i] = (arr[i - 2] - arr[i - 1]) % MOD;
            }
        }

        if(arr[Math.abs(n)] > 0) System.out.println(1);
        else if(arr[Math.abs(n)] < 0) System.out.println(-1);
        else System.out.println(0);

        System.out.println(Math.abs(arr[Math.abs(n)]));
    }
}