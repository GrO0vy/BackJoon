import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int M;
    static int X;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        int[] distance = new int[N + 1];

        List<List<Road>> roads = new ArrayList<>();
        for(int i = 0; i <= M; i++) roads.add(new ArrayList<>());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int source = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            roads.get(source).add(new Road(destination, length));
        }

        for(int i = 1; i <= N; i++){
            int[] result = findMinDistance(i, roads);
            if(i == X){
                for(int j = 1; j <= N; j++){
                    distance[j] += result[j];
                }
            }
            else{
                distance[i] += result[X];
            }
        }

        int max = 0;
        for(int i = 1; i <= N; i++) max = Math.max(max, distance[i]);

        System.out.println(max);
    }

    static int[] findMinDistance(int start, List<List<Road>> roads){
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.distance - o2.distance);
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            Node current = pq.poll();

            for(Road road: roads.get(current.num)){
                if(current.distance + road.length < distance[road.destination]){
                    distance[road.destination] = current.distance + road.length;
                    pq.offer(new Node(road.destination, current.distance + road.length));
                }
            }
        }

        return distance;
    }

    static class Node{
        int num;
        int distance;

        public Node(int num, int distance){
            this.num = num;
            this.distance = distance;
        }
    }

    static class Road{
        int destination;
        int length;

        public Road(int destination, int length){
            this.destination = destination;
            this.length = length;
        }
    }
}