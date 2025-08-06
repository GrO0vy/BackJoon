import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);

        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int node1 = road[0];
            int node2 = road[1];

            adjList.get(node1).add(node2);
            adjList.get(node2).add(node1);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(destination);
        distance[destination] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : adjList.get(current)) {
                if (distance[next] == -1) {
                    distance[next] = distance[current] + 1;
                    queue.offer(next);
                }

            }
        }
        int[] answer = new int[sources.length];

        for (int i = 0; i < sources.length; i++) {
            for (int j = 1; j <= n; j++) {
                if (sources[i] == j) {
                    answer[i] = distance[j];
                    break;
                }
            }
        }
        return answer;
    }
}