import java.io.*;
import java.util.*;

public class Main{
    static int max = 0;
    static int[] deltaX = {-1, 1, 0, 0};
    static int[] deltaY = {0, 0, 1, -1};
    static int N;
    static int M;
    static boolean[][] isVisited;
    static int[][] adjMap;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adjMap = new int[N][M];
        isVisited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                adjMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!isVisited[i][j] && adjMap[i][j] == 1) {
                    max = Math.max(max, bfs(i,j));
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max);
    }

    static int bfs(int row, int col){
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{row, col});
        int size = 0;

        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int curX = pos[0];
            int curY = pos[1];
            
            if(isVisited[curX][curY]) continue;

            isVisited[curX][curY] = true;
            size++;

            for(int i = 0; i < 4; i++){
                int nextX = curX + deltaX[i];
                int nextY = curY + deltaY[i];

                if(inRange(nextX, nextY) && !isVisited[nextX][nextY] && adjMap[nextX][nextY] == 1)
                    queue.add(new int[]{nextX, nextY});
            }
        }

        return size;
    }

    static boolean inRange(int x, int y){
        return -1 < x && x < N && -1 < y && y < M;
    }
}