import java.io.*;
import java.util.*;

public class Main{
    static char[][] map;
    static int N;
    static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int colorArea;
    static int unColorArea;
    static boolean[][] colorVisited;
    static boolean[][] unColorVisited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
        }

        colorVisited = new boolean[N][N];
        unColorVisited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!colorVisited[i][j]) bfsColor(i, j);
                if(!unColorVisited[i][j]) bfsUnColor(i, j);
            }
        }

        System.out.printf("%d %d", colorArea, unColorArea);
    }

    static void bfsColor(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int curX = pos[0];
            int curY = pos[1];

            if(colorVisited[curX][curY]) continue;
            colorVisited[curX][curY] = true;

            for(int[] delta: deltas){
                int nextX = curX + delta[0];
                int nextY = curY + delta[1];

                if(inRange(nextX, nextY) &&
                        map[curX][curY] == map[nextX][nextY] &&
                        !colorVisited[nextX][nextY])
                {
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }

        colorArea++;
    }

    static void bfsUnColor(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int curX = pos[0];
            int curY = pos[1];

            if(unColorVisited[curX][curY]) continue;
            unColorVisited[curX][curY] = true;

            for(int[] delta: deltas){
                int nextX = curX + delta[0];
                int nextY = curY + delta[1];

                if(inRange(nextX, nextY) && !unColorVisited[nextX][nextY])
                {
                    if(map[curX][curY] == 'B'){
                        if(map[nextX][nextY] == 'B') queue.add(new int[]{nextX, nextY});
                    }
                    else{
                        if(map[nextX][nextY] == 'G' || map[nextX][nextY] == 'R')
                            queue.add(new int[]{nextX, nextY});
                    }
                }
            }
        }

        unColorArea++;
    }

    static boolean inRange(int x, int y){
        return -1 < x && x < N && -1 < y && y < N;
    }
}