import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int minValue = Integer.MAX_VALUE;

        int[][] arr = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr[i]);
        }

        int[] idx = new int[N];
        int max = Integer.MIN_VALUE;

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> arr[o1][idx[o1]] - arr[o2][idx[o2]]);
        for(int i = 0; i < N; i++){
            pq.offer(i);
            max = Math.max(max, arr[i][idx[i]]);
        }

        while(!pq.isEmpty()){
            int minIdx = pq.poll();

            int value = max - arr[minIdx][idx[minIdx]];
            if(value < minValue){
                minValue = value;
            }

            idx[minIdx]++;
            if(idx[minIdx] >= M) break;

            max = Math.max(max, arr[minIdx][idx[minIdx]]);
            pq.offer(minIdx);
        }

        System.out.println(minValue);
    }
}