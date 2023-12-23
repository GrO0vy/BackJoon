import java.io.*;
import java.util.*;

public class Main {
    static int digit;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        digit = (int)Math.pow(10, N-1);
        sb = new StringBuilder();

        for(int i = 1; i <= 9; i++){
            prime(i);
        }

        System.out.println(sb);
    }

    static void prime(int x){
        if(!isPrime(x)) return;

        else if(x / digit > 0){
            sb.append(x + "\n");
            return;
        }
        else{
            for(int i = 1; i <=9; i+=2){
                prime(x*10 + i);
            }
        }
    }

    static boolean isPrime(int x){
        boolean flag = true;
        if(x == 1) flag = false;
        else{
            for(int i = 2; i <= Math.sqrt(x); i++){
                if(x % i == 0) flag = false;
            }
        }

        return flag;
    }
}
