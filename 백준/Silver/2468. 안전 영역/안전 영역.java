import java.io.*;
import java.util.*;

public class Main{
    private int[][] area;
    private boolean[][] visited;
    private int N;
    private int[] dx = {0, 1, -1, 0};
    private int[] dy = {1, 0, 0, -1};

    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());

        area = new int[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for(int j = 0; j < N; j++){
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;

        for(int i = 0; i < N; i++){
            for(int num: area[i]){
                if(num > max) max = num;
            }
        }

        int result = 0;

        for(int i = 0; i <= max; i++){
            visited = new boolean[N][N];
            int count = 0;
            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    if(!visited[j][k] && area[j][k] > i) count += dfs(j, k, i);
                }
                if(count > result) result = count;
            }
        }

        System.out.println(result);
    }

    public int dfs(int x, int y, int height){
        visited[x][y] = true;

        for(int i = 0; i < 4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(inRange(nextX, nextY) && area[nextX][nextY] > height && !visited[nextX][nextY]) dfs(nextX, nextY, height);
        }

        return 1;
    }

    public boolean inRange(int x, int y){
        return -1 < x && x < N && -1 < y && y < N;
    }



    public static void main (String[] args) throws IOException{
        new Main().solution();
    }
}