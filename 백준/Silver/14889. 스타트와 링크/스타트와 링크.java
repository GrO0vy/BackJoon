import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int[][] scores;
    static int min;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        scores = new int[N][N];

        min = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                scores[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            dfs(i, new boolean[N],  0);
        }

        System.out.println(min);
    }

    static void dfs(int start, boolean[] check, int count){
        if(count == N / 2){
            int team = 0;
            int opponent = 0;

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(check[i] && check[j]) team += scores[i][j];
                    if(!check[i] && !check[j]) opponent += scores[i][j];
                }
            }

            min = Math.min(min, Math.abs(team - opponent));
            return;
        }

        for(int i = start; i < N; i++){
            check[i] = true;
            dfs(i + 1, check,count + 1);
            check[i] = false;
        }
    }
}