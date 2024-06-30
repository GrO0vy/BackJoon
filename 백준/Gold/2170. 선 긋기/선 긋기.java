import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            if(left > right){
                int temp = left;
                left = right;
                right = temp;
            }

            pq.offer(new int[]{left, right});
        }


        while(!pq.isEmpty()){
            int[] pos = pq.poll();
            int start = pos[0];
            int end = pos[1];

            while(!pq.isEmpty() && pq.peek()[0] <= end){
                end = Math.max(end, pq.poll()[1]);
            }

            answer += end - start;
        }

        System.out.println(answer);
    }
}