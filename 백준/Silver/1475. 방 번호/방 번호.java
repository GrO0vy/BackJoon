import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[9];

        while(N > 0){
            int num = N % 10;
            if(num == 9) arr[6]++;
            else arr[num]++;
            N /= 10;
        }
        arr[6] = (int)Math.ceil(arr[6] / 2.0);

        int max = 0;
        for(int i = 0; i < 9; i++){
            if(arr[i] > max) max = arr[i];
        }

        System.out.println(max);

        sc.close();
    }
}