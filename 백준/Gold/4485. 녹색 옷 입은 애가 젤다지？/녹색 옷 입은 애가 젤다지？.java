import java.util.*;
import java.io.*;

public class Main{
    static final String PRINT_FORMAT = "Problem %d: %d\n";
    static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int testNum = 1;

        while(N > 0){
            int[][] map = new int[N][N];
            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append(String.format(PRINT_FORMAT, testNum, bfs(N, map)));

            N = Integer.parseInt(br.readLine());
            testNum++;
        }

        System.out.println(sb.toString());
    }

    static int bfs(int N, int[][] map){
        boolean[][] visited = new boolean[N][N];

        PriorityQueue<Pos> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.offer(new Pos(0, 0, map[0][0]));

        while(!pq.isEmpty()){
            Pos current = pq.poll();

            if(visited[current.x][current.y]) continue;

            if(current.x == N - 1 && current.y == N - 1) return current.cost;

            visited[current.x][current.y] = true;

            for(int[] delta: deltas){
                int nextX = current.x + delta[0];
                int nextY = current.y + delta[1];

                if(inRange(nextX, nextY, N) && !visited[nextX][nextY]){
                    pq.offer(new Pos(nextX, nextY, current.cost + map[nextX][nextY]));
                }
            }
        }

        return -1;
    }

    static boolean inRange(int x, int y, int N){
        return -1 < x && x < N && -1 < y && y < N;
    }

    static class Pos{
        int x;
        int y;
        int cost;

        public Pos(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}