import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        int cnt = 0;
        for(int i = N - 2; i >= 0; i--){
            while(arr[i] >= arr[i + 1]) {
                arr[i]--;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}