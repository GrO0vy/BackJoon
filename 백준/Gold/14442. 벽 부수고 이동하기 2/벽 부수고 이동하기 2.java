import java.util.*;
import java.io.*;

public class Main{
    static char[][] map;
    static boolean[][][] visited;
    static int N;
    static int M;
    static int K;
    static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
        }

        visited = new boolean[N][M][K + 1];

        System.out.println(bfs(new Pos(0, 0, K, 1)));
    }

    static int bfs(Pos start){
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()){
            Pos current = queue.poll();

            if(current.x == N - 1 && current.y == M - 1){
                return current.distance;
            }

            for(int[] delta: deltas){
                int nextX = current.x + delta[0];
                int nextY = current.y + delta[1];

                if(inRange(nextX, nextY)){
                    if(map[nextX][nextY] == '0'){
                        if(!visited[nextX][nextY][current.breakable]){
                            queue.offer(new Pos(nextX, nextY, current.breakable, current.distance + 1));
                            visited[nextX][nextY][current.breakable] = true;
                        }
                    }
                    else{
                        if(current.breakable > 0 && !visited[nextX][nextY][current.breakable - 1]){
                            queue.offer(new Pos(nextX, nextY, current.breakable - 1, current.distance + 1));
                            visited[nextX][nextY][current.breakable - 1] = true;
                        }

                    }
                }
            }
        }

        return -1;
    }

    static boolean inRange(int x, int y){
        return -1 < x && x < N && -1 < y && y < M;
    }


    static class Pos{
        int x;
        int y;
        int breakable;
        int distance;

        public Pos(int x, int y, int breakable, int distance){
            this.x = x;
            this.y = y;
            this.breakable = breakable;
            this.distance = distance;
        }
    }
}