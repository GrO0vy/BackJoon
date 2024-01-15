import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        long answer = divide(A, B, C);

        System.out.println(answer);
    }

    static long divide(long A, long B, long C){
        if(B == 1) return A % C;
        else if(B % 2 == 0) return twice(divide(A, B/2, C)) % C;
        else return A * divide(A, B - 1, C) % C;
    }

    private static long twice(long num){
        return num * num;
    }
}