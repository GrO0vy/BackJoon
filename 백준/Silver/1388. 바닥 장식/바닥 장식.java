import java.util.*;
import java.io.*;

public class Main{
    private char[][] floor;
    private boolean[][] visited;
    private int height;
    private int width;

    public void solution() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sizeInfo = new StringTokenizer(reader.readLine());
        height = Integer.parseInt(sizeInfo.nextToken());
        width = Integer.parseInt(sizeInfo.nextToken());

        visited = new boolean[height][width];
        floor = new char[height][width];
        for(int i = 0; i < height; i++){
            floor[i] = reader.readLine().toCharArray();
        }

        int result = 0;

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(!visited[i][j]) {
                    dfs(i,j);
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    private void dfs(int x, int y){
        visited[x][y] = true;

        char token = floor[x][y];
        if(token == '-'){
            if(inRange(x,y+1) && floor[x][y+1] == token) dfs(x,y+1);
        }
        else if(token == '|'){
            if(inRange(x+1,y) && floor[x+1][y] == token) dfs(x+1,y);
        }
    }

    private boolean inRange(int x, int y){
        return -1 < x && x < height && -1 < y && y < width;
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}