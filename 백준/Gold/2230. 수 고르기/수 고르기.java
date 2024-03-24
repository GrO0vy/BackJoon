import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        for(int i = 0; i < N; i++) A[i] = Integer.parseInt(br.readLine());

        Arrays.sort(A);

        int left = 0;
        int right = 1;
        int min = Integer.MAX_VALUE;

        while(right < A.length){
            if(left == right){
                right++;
                continue;
            }

            int gap = A[right] - A[left];
            if(gap < M) right++;
            else{
                min = Math.min(min, gap);
                left++;
            }
        }

        System.out.println(min);
    }
}