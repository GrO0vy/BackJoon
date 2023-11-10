import java.io.*;
import java.util.*;

public class Main{
    int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int[][] adjMat;
    boolean[][] isVisited;
    int N;
    int M;

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjMat = new int[N][M];
        isVisited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                adjMat[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(adjMat[N - 1][M - 1]);
    }

    void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        isVisited[x][y] = true;

        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            for(int[] delta: deltas){
                int nextX = pos[0] - delta[0];
                int nextY = pos[1] - delta[1];

                if(inRange(nextX, nextY) && adjMat[nextX][nextY] != 0 && !isVisited[nextX][nextY]){
                    queue.offer(new int[]{nextX, nextY});
                    isVisited[nextX][nextY] = true;
                    adjMat[nextX][nextY] = adjMat[pos[0]][pos[1]] + 1;
                }
            }
        }
    }

    boolean inRange(int x, int y){
        return -1 < x && x < N && -1 < y && y < M;
    }
}