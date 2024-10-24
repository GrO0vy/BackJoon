import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int[] arr = new int[N + 1];
        arr[1] = 1;
        
        for(int i = 2; i <= N; i++){
            arr[i] = i;
            
            for(int j = 1; j <= (int)Math.sqrt(i); j++){
                arr[i] = Math.min(arr[i], arr[i - j * j] + 1); 
            }
        }
        
        System.out.println(arr[N]);
    }
}