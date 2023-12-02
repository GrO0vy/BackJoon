import java.util.StringTokenizer;
import java.io.*;

public class Main{
    static long maxDivisor = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        
        if(A < B){
            long temp = A;
            A = B;
            B = temp;
        }
        
        gcd(A, B);
        System.out.println(A * B / maxDivisor);
    }
    
    static void gcd(long A, long B){
        if(A % B == 0){
            maxDivisor = B;
            return;
        }
        gcd(B, A % B);
    }
}