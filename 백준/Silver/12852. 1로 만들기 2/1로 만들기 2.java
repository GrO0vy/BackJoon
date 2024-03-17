import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N + 1];

        for(int i = 2; i <= N; i++){
            arr[i] = arr[i - 1] + 1;
            if(i % 2 == 0) arr[i] = Math.min(arr[i / 2] + 1, arr[i]);
            if(i % 3 == 0) arr[i] = Math.min(arr[i / 3] + 1, arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        int idx = N;
        while(idx >= 1){
            sb.append(idx + " ");
            if(arr[idx - 1] == arr[idx] - 1){
                idx = idx - 1;
            }
            else if(idx % 2 == 0 && arr[idx / 2] == arr[idx] - 1){
                idx = idx / 2;
            }
            else{
                idx = idx / 3;
            }
        }

        System.out.println(arr[N]);
        System.out.println(sb);
    }
}