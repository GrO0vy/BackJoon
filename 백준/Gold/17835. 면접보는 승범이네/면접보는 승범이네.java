// 1. 모든 면접장에 대해서 다익스트라
// 2. 각 면접장에 대한 다익스트라 결과에서 가장 거리가 긴 위치와 길이를 리턴
// 3. 최종적으로 모든 면접장에서 가장 먼 면접자 중 제일 먼 면접자를 출력

import java.util.*;
import java.io.*;

public class Main{
    static List<List<Edge>> adjList;
    static int[] endPoints;
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>();
        for(int i = 0; i <= N; i++) adjList.add(new ArrayList<>());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int source = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            adjList.get(destination).add(new Edge(source, length));
        }

        st = new StringTokenizer(br.readLine());

        endPoints = new int[K];
        for(int i = 0; i < K; i++) endPoints[i] = Integer.parseInt(st.nextToken());

        long[] result = findMaxLength();

        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    static long[] findMaxLength(){
        boolean[] visited = new boolean[N + 1];

        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Long.compare(dist[o1], dist[o2]));
        for(int endPoint: endPoints){
            dist[endPoint] = 0;
            pq.offer(endPoint);
        }


        while(!pq.isEmpty()){
            int current = pq.poll();

            if(visited[current]) continue;
            visited[current] = true;

            for(Edge edge: adjList.get(current)){
                long nextLength = dist[current] + edge.length;

                if(nextLength < dist[edge.destination]){
                    dist[edge.destination] = nextLength;
                    pq.offer(edge.destination);
                }
            }
        }

        int maxPerson = 0;
        long maxLength = 0;

        for(int i = 1; i <= N; i++){
            if(!visited[i]) continue;

            if(dist[i] > maxLength){
                maxPerson = i;
                maxLength = dist[i];
            }
        }

        return new long[]{maxPerson, maxLength};
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