import java.io.*;
import java.util.*;

public class Main{
    static int[][] deltas = {{1,0}, {-1,0}, {0,1}, {0, -1}};
    static int result = 0;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        isVisited = new boolean[M][N];

        for(int i =0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = M - Integer.parseInt(st.nextToken()) - 1;
            int xEnd = Integer.parseInt(st.nextToken());
            int yEnd = M - Integer.parseInt(st.nextToken());

            for(int j = y; j >= yEnd; j--){
                for(int k = x; k < xEnd; k++){
                    isVisited[j][k] = true;
                }
            }
        }

        int count = 0;
        List<Integer> results = new ArrayList<>();


        for(int i = 0; i < isVisited.length; i++){
            for(int j = 0; j < isVisited[0].length; j++){
                if(!isVisited[i][j]){
                    dfs(i, j);
                    results.add(result);
                    count++;
                    result = 0;
                }
            }
        }

        Collections.sort(results);

        System.out.println(count);
        for(int num: results) System.out.print(num + " ");
    }

    static void dfs(int x, int y){
        if(!isVisited[x][y]){
            isVisited[x][y] = true;
            result++;

            for(int[] delta: deltas){
                int deltaX = delta[0];
                int deltaY = delta[1];
                int nextX = x + deltaX;
                int nextY = y + deltaY;

                if(inRange(nextX, nextY) && !isVisited[nextX][nextY]) {
                    dfs(nextX, nextY);
                }
            }
        }
    }

    static boolean inRange(int x, int y){
        return -1 < x && x < isVisited.length && -1 < y && y < isVisited[0].length;
    }
}