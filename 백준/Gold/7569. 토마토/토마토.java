import java.io.*;
import java.util.*;

public class Main{
    static int M;
    static int N;
    static int H;
    static int[][][] storage;
    static boolean[][][] visited;
    static Queue<int[]> queue;
    static int result;
    static int[][] deltas = {{-1, 0, 0}, {1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0 , -1}};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        storage = new int[H][N][M];
        visited = new boolean[H][N][M];

        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < M; k++){
                    storage[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        queue = new LinkedList<>();

        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    if(storage[i][j][k] == 1) queue.add(new int[]{i, j, k, 0});
                }
            }
        }

        bfs();

        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    if(storage[i][j][k] == 0){
                        result = -1;
                        break;
                    }
                }
            }
        }

        System.out.println(result);
    }

    static void bfs(){
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int curZ = pos[0];
            int curX = pos[1];
            int curY = pos[2];
            int day = pos[3];

            if(visited[curZ][curX][curY]) continue;
            visited[curZ][curX][curY] = true;
            storage[curZ][curX][curY] = 1;

            for(int[] delta: deltas){
                int nextZ = curZ + delta[0];
                int nextX = curX + delta[1];
                int nextY = curY + delta[2];

                if(inRange(nextZ, nextX, nextY) &&
                        !visited[nextZ][nextX][nextY] &&
                        storage[nextZ][nextX][nextY] == 0)
                {
                    queue.add(new int[]{nextZ, nextX, nextY, day + 1});
                }
            }

            result = day;
        }
    }

    static boolean inRange(int z, int x, int y){
        return -1 < z && z < H && -1 < x && x < N && -1 < y && y < M;
    }
}