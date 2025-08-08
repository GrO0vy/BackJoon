import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Node>> adjList = new ArrayList<>();
        for(int i = 0; i <= N; i++) adjList.add(new ArrayList<>());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adjList.get(node1).add(new Node(node2, cost));
            adjList.get(node2).add(new Node(node1, cost));
        }

        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.offer(new Node(1, 0));
        distance[1] = 0;

        while(!pq.isEmpty()){
            Node current = pq.poll();

            for(Node next: adjList.get(current.node)){
                if(distance[next.node] > current.cost + next.cost){
                    distance[next.node] = current.cost + next.cost;
                    pq.offer(new Node(next.node, current.cost + next.cost));
                }
            }
        }

        System.out.println(distance[N]);
    }

    static class Node{
        int node;
        int cost;

        public Node(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }
}