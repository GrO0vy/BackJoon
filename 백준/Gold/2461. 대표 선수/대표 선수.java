import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] pointer = new int[N];
        int[][] arr = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr[i]);
        }

        int result = Integer.MAX_VALUE;

        while(true){
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int minIdx = 0;

            for(int i = 0; i < N; i++){
                if(arr[i][pointer[i]] < min) {
                    min = arr[i][pointer[i]];
                    minIdx = i;
                }

                if(arr[i][pointer[i]] > max) max = arr[i][pointer[i]];
            }

            result = Math.min(result, max - min);
            pointer[minIdx]++;

            if(pointer[minIdx] == M) break;
        }

        System.out.println(result);
    }
}