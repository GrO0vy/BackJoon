import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder result = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 3; i++) pq.offer(Integer.parseInt(st.nextToken()));

            int a = pq.poll();
            int b = pq.poll();
            int c = pq.poll();

            if(a == 0 && b == 0 && c == 0) break;

            if(c * c == a * a + b * b) result.append("right\n");
            else result.append("wrong\n");
        }

        System.out.println(result);
    }
}