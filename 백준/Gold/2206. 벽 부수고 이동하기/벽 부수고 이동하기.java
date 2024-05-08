import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int M;
    static char[][] map;
    static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static class LOC{
        int x;
        int y;
        int distance;
        boolean isBreak;

        public LOC(int x, int y, int distance, boolean isBreak){
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.isBreak = isBreak;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for(int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();

        boolean[][][] visited = new boolean[2][N][M];

        System.out.println(bfs(new LOC(0, 0, 1, false), visited));
    }

    static int bfs(LOC l, boolean[][][] visited){
        Queue<LOC> queue = new LinkedList<>();
        queue.add(l);
        int minDistance = -1;

        while(!queue.isEmpty()){
            LOC pos = queue.poll();
            int curX = pos.x;
            int curY = pos.y;
            int distance = pos.distance;
            boolean isBreak = pos.isBreak;

            if(curX == N - 1 && curY == M - 1){
                minDistance = distance;
                break;
            }

            for(int[] delta : deltas){
                int nextX = curX + delta[0];
                int nextY = curY + delta[1];

                if(inRange(nextX, nextY)){
                    if(map[nextX][nextY] == '0'){
                        if(!isBreak){
                            if(!visited[0][nextX][nextY]) queue.offer(new LOC(nextX, nextY, distance + 1, false));
                            visited[0][nextX][nextY] = true;
                        }
                        else {
                            if (!visited[1][nextX][nextY]) queue.offer(new LOC(nextX, nextY, distance + 1, true));
                            visited[1][nextX][nextY] = true;
                        }
                    }
                    else{
                        if(!isBreak) {
                            visited[1][nextX][nextY] = true;
                            queue.offer(new LOC(nextX, nextY, distance + 1, true));
                        }
                    }
                }
            }
        }

        return minDistance;
    }

    static boolean inRange(int x, int y){
        return -1 < x && x < N && -1 < y && y < M;
    }
}