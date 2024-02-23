import java.util.Scanner;

public class Main{
    static int n;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int[] arr = new int[n + 2];
        arr[1] = 1;

        solution(2, arr);
        System.out.println(arr[n]);
    }

    static void solution(int idx, int[] arr){
        if(idx > n) return;
        arr[idx] = arr[idx - 1] + arr[idx - 2];
        solution(idx + 1, arr);
    }
}