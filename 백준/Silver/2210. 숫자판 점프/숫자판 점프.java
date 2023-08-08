import java.io.*;
import java.util.*;

public class Main{
    int[][] deltas = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    Set<String> set;
    int[][] matrix;

    public void solution() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        set = new HashSet<>();
        matrix = new int[5][5];

        for(int i = 0; i < 5; i++){
            StringTokenizer digitInfo = new StringTokenizer(reader.readLine());
            for(int j = 0; j < 5; j++){
                matrix[i][j] = Integer.parseInt(digitInfo.nextToken());
            }
        }

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                dfs(0, i, j, "");
            }
        }

        System.out.println(set.size());
    }

    private void dfs(int count, int posX, int posY, String result){
        if(count == 6){
            set.add(result);
            return;
        }

        result += matrix[posX][posY];

        for(int[] delta: deltas){
            int nextX = posX + delta[0];
            int nextY = posY + delta[1];

            if(inRange(nextX, nextY))
                dfs(count + 1, nextX, nextY, result);
        }
    }

    private boolean inRange(int posX, int posY){
        return -1 < posX && posX < 5 && -1 < posY && posY < 5;
    }
    
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}