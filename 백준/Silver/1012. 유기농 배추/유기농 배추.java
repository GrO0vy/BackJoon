import java.io.IOException;
import java.util.*;
import java.io.*;

public class Main {
    private int width;
    private int height;
    private int[][] deltas = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    public void solution() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        for(int i = 0; i < T; i++){
            StringTokenizer info = new StringTokenizer(reader.readLine());
            width = Integer.parseInt(info.nextToken());
            height = Integer.parseInt(info.nextToken());
            int count = Integer.parseInt(info.nextToken());

            int[][] map = new int[height][width];

            for(int j = 0; j < count; j++){
                StringTokenizer pos = new StringTokenizer(reader.readLine());
                int y = Integer.parseInt(pos.nextToken());
                int x = Integer.parseInt(pos.nextToken());

                map[x][y] = 1;
            }

            boolean[][] visited = new boolean[height][width];
            int result = 0;

            for(int j = 0; j < height; j++){
                for(int k = 0; k < width; k++){
                    if(map[j][k] == 1 && !visited[j][k]){
                        Stack<int[]> stack = new Stack<>();
                        stack.push(new int[]{j, k});
                        while(!stack.isEmpty()){
                            int[] pos = stack.pop();
                            int x = pos[0];
                            int y = pos[1];

                            visited[x][y] = true;
                            for(int[] delta: deltas){
                                int nextX = x - delta[0];
                                int nextY = y - delta[1];

                                if(inRange(nextX,nextY) && !visited[nextX][nextY] && map[nextX][nextY] == 1 )
                                    stack.push(new int[]{nextX, nextY});
                            }
                        }
                        result++;
                    }
                }
            }
            System.out.println(result);
        }

    }

    private boolean inRange(int x, int y){
        return -1 < x && x < height && -1 < y && y < width;
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}