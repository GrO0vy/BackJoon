import java.util.*;
import java.io.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] distance = new int[D + 1];
        for(int i = 0; i <= D; i++) distance[i] = i;

        PriorityQueue<Straight> pq = new PriorityQueue<>((o1, o2) -> o1.end - o2.end);
        for(int i = 0; i < N; i++){
            String[] info = br.readLine().split(" ");

            int start = Integer.parseInt(info[0]);
            int end = Integer.parseInt(info[1]);
            int length = Integer.parseInt(info[2]);

            pq.offer(new Straight(start, end, length));
        }

        for(int i = 1; i <= D; i++){
            distance[i] = Math.min(distance[i], distance[i - 1] + 1);
            
            if(!pq.isEmpty() && pq.peek().end == i){
                while(!pq.isEmpty() && pq.peek().end == i){
                    Straight s = pq.poll();

                    if(s.end > D) break;

                    distance[s.end] = Math.min(distance[s.end], distance[s.start] + s.length);
                }
            }
        }
        
        System.out.println(distance[D]);
    }

    static class Straight{
        int start;
        int end;
        int length;

        public Straight(int start, int end, int length){
            this.start = start;
            this.end = end;
            this.length = length;
        }
    }
}