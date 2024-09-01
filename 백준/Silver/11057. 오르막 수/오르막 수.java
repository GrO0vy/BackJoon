import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        long[][] arr = new long[N + 1][10];
        arr[1] = new long[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        for(int i = 2; i <= N; i++){
            for(int j = 0; j < 10; j++){
                for(int k = 0; k <= j; k++){
                    arr[i][j] += arr[i - 1][k];
                }
                arr[i][j] %= 10007;
            }    
        }
        
        int result = 0;
        for(int i = 0; i < 10; i++) result += arr[N][i];
        
        result %= 10007;
        System.out.println(result);
    }
}