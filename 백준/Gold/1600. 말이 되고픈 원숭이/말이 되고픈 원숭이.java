import java.util.*;
import java.io.*;

public class Main{
    static int W;
    static int H;
    static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[][] horseDeltas = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1},{1, 2}, {1, -2}, {-1, 2}, {-1, -2}};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int[][] map = new int[H][W];

        for(int i = 0; i < H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < W; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][][] visited = new boolean[H][W][K + 1];

        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(0, 0, 0, K));

        int result = -1;

        while(!queue.isEmpty()){
            Pos current = queue.poll();

            if(visited[current.x][current.y][current.cntHorse]) continue;

            if(current.x == H - 1 && current.y == W - 1){
                result = current.distance;
                break;
            }

            visited[current.x][current.y][current.cntHorse] = true;

            for(int[] delta: deltas){
                int nextX = current.x + delta[0];
                int nextY = current.y + delta[1];

                if(inRange(nextX, nextY) && !visited[nextX][nextY][current.cntHorse] && map[nextX][nextY] == 0)
                    queue.offer(new Pos(nextX, nextY, current.distance + 1, current.cntHorse));
            }

            if(current.cntHorse > 0){
                for(int[] horseDelta: horseDeltas){
                    int nextX = current.x + horseDelta[0];
                    int nextY = current.y + horseDelta[1];

                    if(inRange(nextX, nextY) && !visited[nextX][nextY][current.cntHorse] && map[nextX][nextY] == 0)
                        queue.offer(new Pos(nextX, nextY, current.distance + 1, current.cntHorse - 1));
                }
            }
        }

        System.out.println(result);
    }

    static boolean inRange(int x, int y){
        return -1 < x && x < H && -1 < y && y < W;
    }

    static class Pos{
        int x;
        int y;
        int distance;
        int cntHorse;

        public Pos(int x, int y, int distance, int cntHorse){
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.cntHorse = cntHorse;
        }
    }
}