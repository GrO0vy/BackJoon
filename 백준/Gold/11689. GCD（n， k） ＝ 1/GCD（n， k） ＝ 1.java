import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long result = N;

        for(long i = 2; i <= Math.sqrt(N); i++){
            if(N % i == 0L){
                result = result - (result / i);
                while(N % i == 0L) N /= i;
            }
        }
        
        if(N > 1){
            result = result - (result / N);
        }
        System.out.println(result);
    }
}