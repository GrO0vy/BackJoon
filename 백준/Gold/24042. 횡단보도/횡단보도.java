import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<List<Road>> roadList = new ArrayList<>();
        for(int i = 0; i <= N; i++) roadList.add(new ArrayList<>());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            roadList.get(node1).add(new Road(node2, i));
            roadList.get(node2).add(new Road(node1, i));
        }

        long[] time = new long[N + 1];
        Arrays.fill(time, Long.MAX_VALUE);

        PriorityQueue<Pos> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.time <= o2.time) return -1;
            else return 1;
        });

        pq.offer(new Pos(1, 0));
        time[1] = 0;

        while(!pq.isEmpty()){
            Pos current = pq.poll();

            for(Road nextRoad: roadList.get(current.node)){
                long nextTime = 0;

                if(current.time % M <= nextRoad.roadIdx){
                    nextTime = current.time + (nextRoad.roadIdx - current.time % M) + 1;
                }
                else{
                    long cycle = current.time / M;
                    if(current.time % M > 0) cycle++;

                    nextTime = M * cycle + nextRoad.roadIdx + 1;
                }

                if(nextTime < time[nextRoad.destination]){
                    time[nextRoad.destination] = nextTime;
                    pq.offer(new Pos(nextRoad.destination, nextTime));
                }
            }
        }

        System.out.println(time[N]);
    }

    static class Road{
        int destination;
        int roadIdx;

        public Road(int destination, int roadIdx){
            this.destination = destination;
            this.roadIdx = roadIdx;
        }
    }

    static class Pos{
        int node;
        long time;

        public Pos(int node, long time){
            this.node = node;
            this.time = time;
        }
    }
}