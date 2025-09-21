import java.util.*;
import java.io.*;

public class Main{
    static List<List<Edge>> adjList;
    static int N;
    static int[] distRoot;
    static int[] distNode1;
    static int[] distNode2;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>();
        for(int i = 0; i <= N; i++) adjList.add(new ArrayList<>());

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            adjList.get(node1).add(new Edge(node2, length));
            adjList.get(node2).add(new Edge(node1, length));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 1. 출발점, 노드1, 노드2 에서 다익스트라를 한다.
        // 2. 다익스트라 결과를 각각 배열에 저장한다.
        // 3. 출발점 -> 노드1 -> 노드2 -> 도착점 와 출발점 노드 2 -> 노드 1 -> 도착점 중 최소를 출력한다.
        // 만약 이동경로 중 거리가 Integer.MAV_VALUE 인 경로가 있다면 -1 출력

        distRoot = getDist(1);
        distNode1 = getDist(v1);
        distNode2 = getDist(v2);

        System.out.println(getMinPath(v1, v2));
    }

    static int[] getDist(int root){
        boolean[] visited = new boolean[N + 1];

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[root] = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> dist[o1] - dist[o2]);
        pq.offer(root);

        while(!pq.isEmpty()){
            int current = pq.poll();

            if(visited[current]) continue;
            visited[current] = true;

            for(Edge edge: adjList.get(current)){
                int nextLength = dist[current] + edge.length;

                if(nextLength < dist[edge.destination]){
                    dist[edge.destination] = nextLength;
                    pq.offer(edge.destination);
                }
            }
        }

        return dist;
    }

    static int getMinPath(int node1, int node2){
        int length1 = -1;
        int rootToNode1 = distRoot[node1];
        int nodeToNode1 = distNode1[node2];
        int nodeToEnd1 = distNode2[N];

        if(rootToNode1 != Integer.MAX_VALUE && nodeToNode1 != Integer.MAX_VALUE && nodeToEnd1 != Integer.MAX_VALUE){
            length1 = rootToNode1 + nodeToNode1 + nodeToEnd1;
        }

        int length2 = -1;
        int rootToNode2 = distRoot[node2];
        int nodeToNode2 = distNode2[node1];
        int nodeToEnd2 = distNode1[N];

        if(rootToNode2 != Integer.MAX_VALUE && nodeToNode2 != Integer.MAX_VALUE && nodeToEnd2 != Integer.MAX_VALUE){
            length2 = rootToNode2 + nodeToNode2 + nodeToEnd2;
        }

        int result = Integer.MAX_VALUE;
        if(length1 != -1) result = Math.min(result, length1);
        if(length2 != -1) result = Math.min(result, length2);

        return result == Integer.MAX_VALUE ? -1 : result;
    }


    static class Edge{
        int destination;
        int length;

        public Edge(int destination, int length){
            this.destination = destination;
            this.length = length;
        }
    }
}