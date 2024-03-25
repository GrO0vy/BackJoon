import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 0; i < T; i++){
            int N = sc.nextInt();
            long[] arr = new long[N + 3];
            arr[1] = 1; arr[2] = 1; arr[3] = 1;

            for(int j = 4; j <= N; j++){
                arr[j] = arr[j - 3] + arr[j - 2];
            }

            System.out.println(arr[N]);
        }
    }
}