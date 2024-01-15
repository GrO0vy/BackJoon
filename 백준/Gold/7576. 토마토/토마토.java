import java.io.*;
import java.util.*;

public class Main{
static int M;
    static int N;
    static int[][] adjMap;
    static boolean[][] isVisited;
    static int min = Integer.MAX_VALUE;
    static int[] deltaX = {-1, 1, 0, 0};
    static int[] deltaY = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        adjMap = new int[N][M];
        isVisited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                adjMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        min = bfs();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(adjMap[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(min);
    }

    static int bfs(){
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(adjMap[i][j] == 1) queue.add(new int[]{i, j, 0});
            }
        }

        int cnt = 0;
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int curX = pos[0];
            int curY = pos[1];
            int day = pos[2];

            if(isVisited[curX][curY]) continue;

            isVisited[curX][curY] = true;
            adjMap[curX][curY] = 1;
            cnt = day;

            for(int i = 0; i < 4; i++){
                int nextX = curX + deltaX[i];
                int nextY = curY + deltaY[i];

                if(inRange(nextX, nextY) && !isVisited[nextX][nextY] && adjMap[nextX][nextY] == 0)
                    queue.offer(new int[]{nextX, nextY, day + 1});
            }
        }

        return cnt;
    }

    static boolean inRange(int x, int y){
        return -1 < x && x < N && -1 < y && y < M;
    }
}