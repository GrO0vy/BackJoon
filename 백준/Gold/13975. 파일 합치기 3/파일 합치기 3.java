import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {

            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");

            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int i = 0; i < N; i++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }

            long answer = 0;

            while(true){

                if(pq.size() == 1) break;
                long num1 = pq.poll();
                long num2 = pq.poll();

                answer += num1+num2;
                pq.offer(num1 + num2);
            }
            System.out.println(answer);
        }
    }
}