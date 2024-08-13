import java.util.*;
import java.io.*;

public class Main{
    static int K;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        hanoi(N, 1, 2, 3);

        System.out.println(K);
        System.out.println(sb);
    }

    static void hanoi(int height, int start, int mid, int to){
        if(height == 1){
            sb.append(start + " " + to + "\n");
            K += 1;
            return;
        }

        hanoi(height - 1, start, to, mid);

        sb.append(start + " " + to + "\n");
        K += 1;

        hanoi(height - 1, mid, start, to);
    }
}