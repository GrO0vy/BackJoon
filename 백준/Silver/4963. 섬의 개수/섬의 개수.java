import java.util.*;
import java.io.*;

public class Main{
    private int width;
    private int height;
    private boolean[][] visited;
    private int[][] map;
    private int[][] deltas = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}
    };

    public void solution() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer mapSize = new StringTokenizer(reader.readLine());
            width = Integer.parseInt(mapSize.nextToken());
            height = Integer.parseInt(mapSize.nextToken());

            if(width == 0 && height == 0) break;

            map = new int[height][width];

            for(int i = 0; i < height; i++){
                StringTokenizer mapInfo = new StringTokenizer(reader.readLine());
                for(int j = 0; j < width; j++){
                    map[i][j] = Integer.parseInt(mapInfo.nextToken());
                }
            }

            visited = new boolean[height][width];

            int count = 0;
            for(int i = 0; i < height; i++){
                for(int j = 0; j < width; j++){
                    if(!visited[i][j] && map[i][j] == 1){
                        dfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    private void dfs(int x, int y){
        visited[x][y] = true;

        for(int[] delta: deltas){
            int nextX = x - delta[0];
            int nextY = y - delta[1];

            if(inRange(nextX, nextY) && !visited[nextX][nextY] && map[nextX][nextY] == 1 )
                dfs(nextX, nextY);
        }
    }

    private boolean inRange(int x, int y){
        return -1 < x && x < height && -1 < y && y < width;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}