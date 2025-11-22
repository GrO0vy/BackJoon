import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int M;
    static int[] parent;
    static List<Node> nodes;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for(int i = 1; i <= N; i++) parent[i] = i;

        nodes = new ArrayList<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            nodes.add(new Node(x, y));
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            union(node1, node2);
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> Double.compare(o1.distance, o2.distance));
        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N; j++){
                Node node1 = nodes.get(i);
                Node node2 = nodes.get(j);

                long disX = (long)Math.pow(node1.x - node2.x, 2);
                long disY = (long)Math.pow(node1.y - node2.y, 2);
                double distance = Math.sqrt(disX + disY);

                pq.offer(new Edge(i + 1, j + 1, distance));
            }
        }

        double result = 0;

        while(!pq.isEmpty()){
            Edge edge = pq.poll();

            if(union(edge.start, edge.end)){
                union(edge.start, edge.end);
                result += edge.distance;
            }
        }

        System.out.printf("%.2f", result);
    }

    static int find(int node){
        if(parent[node] == node) return node;

        return parent[node] = find(parent[node]);
    }

    static boolean union(int node1, int node2){
        int parent1 = find(node1);
        int parent2 = find(node2);

        if(parent1 == parent2){
            return false;
        }

        parent[parent1] = parent[parent2];
        return true;
    }


    static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static class Edge{
        int start;
        int end;
        double distance;

        public Edge(int start, int end, double distance){
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }
}