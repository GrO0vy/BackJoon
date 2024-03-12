import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] costs = new int[N + 1];
        int[] maxArr = new int[N + 1];

        for(int i = 1; i <= N; i++){
            costs[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= i; j++){
                maxArr[i] = Math.max(maxArr[i], maxArr[i - j] + costs[j]);
            }
        }

        System.out.println(maxArr[N]);
    }
}