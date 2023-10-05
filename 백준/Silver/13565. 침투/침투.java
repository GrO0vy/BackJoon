import java.io.*;
import java.util.*;

public class Main{
    private int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private char[][] figure;
    private boolean result;
    private int height;
    private int width;

    public void solution() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        figure = new char[height][width];

        for(int i = 0; i < height; i++){
            figure[i] = reader.readLine().toCharArray();
        }

        for(int i = 0; i < width; i++){
            if(figure[0][i] == '0') {
                dfs(0, i, new boolean[height][width]);
                if(result) {
                    System.out.println("YES");
                    break;
                }
            }
        }
        if(!result) System.out.println("NO");
    }

    public void dfs(int x, int y, boolean[][] check){
        if(inRange(x, y) && x == height - 1 ) {
            result = true;
            return;
        }

        else{
            check[x][y] = true;

            for(int[] delta: deltas){
                int nextX = x + delta[0];
                int nextY = y + delta[1];

                if(inRange(nextX, nextY) && figure[nextX][nextY] == '0' && !check[nextX][nextY]) dfs(nextX, nextY, check);
            }
        }
    }

    public boolean inRange(int x, int y){
        return -1 < x && x < height && -1 < y && y < width;
    }


    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}