import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) trees[i] = Integer.parseInt(st.nextToken());

        int max = 0;
        for(int i = 0; i < N; i++) max = Math.max(max, trees[i]);

        System.out.println(binarySearch(trees, max));
    }

    static int binarySearch(int[] trees, int max){
        int start = 0;
        int end = max;
        int result = 0;

        while(start <= end){
            int H = (start + end) / 2;

            if(isPossible(trees, H)){
                result = H;
                start = H + 1;
            }
            else end = H - 1;
        }

        return result;
    }

    static boolean isPossible(int[] trees, int H){
        long len = 0;
        for(int i = 0; i < N; i++){
            if(trees[i] - H > 0) len += trees[i] - H;
        }

        return len >= M;
    }
}