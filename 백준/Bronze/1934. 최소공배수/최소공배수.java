import java.util.*;
import java.io.*;

public class Main{
    static int maxDivisor = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (A > B) {
                int temp = A;
                A = B;
                B = temp;
            }

            gcd(A, B);
            System.out.println(A * B / maxDivisor);
        }
    }

    static void gcd(int A, int B){
        if(B % A == 0) {
            maxDivisor = A;
            return;
        }
        gcd(B % A, A);
    }
}