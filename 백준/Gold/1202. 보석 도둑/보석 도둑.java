import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> jewels = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]); // 0번째는 무게, 1번째는 가격
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            jewels.offer(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        int[] bags = new int[K];
        for(int i = 0; i < K; i++) bags[i] = Integer.parseInt(br.readLine());

        Arrays.sort(bags);

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        long result = 0;

        for(int bag: bags){
            while(!jewels.isEmpty() && bag >= jewels.peek()[0]) pq.offer(jewels.poll());

            if(!pq.isEmpty()) result += pq.poll()[1];
        }

        System.out.println(result);
    }
}