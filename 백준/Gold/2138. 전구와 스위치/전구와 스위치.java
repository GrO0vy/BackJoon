import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] switches = new int[2][N];
        String[] input = br.readLine().split("");

        for(int i = 0; i < N; i++) {
            switches[0][i] = Integer.parseInt(input[i]);
            switches[1][i] = switches[0][i];
        }

        switches[1][0] = switches[1][0] == 0 ? 1 : 0;
        switches[1][1] = switches[1][1] == 0 ? 1 : 0;

        int[] target = new int[N];

        input = br.readLine().split("");
        for(int i = 0; i < N; i++) target[i] = Integer.parseInt(input[i]);

        int min = Integer.MAX_VALUE;

        for(int i = 0; i < 2; i++){
            int count = 0;
            if(i == 1) count++;

            for(int j = 1; j < N; j++){
                if(switches[i][j - 1] != target[j - 1]){
                    switches[i][j - 1] = switches[i][j - 1] == 0 ? 1 : 0;
                    switches[i][j] = switches[i][j] == 0 ? 1 : 0;
                    if(j + 1 < N ) switches[i][j + 1] = switches[i][j + 1] == 0 ? 1 : 0;
                    count++;
                }
            }

            if(switches[i][N - 1] == target[N - 1]) min = Math.min(min, count);
        }
        
        System.out.println(min == Integer.MAX_VALUE ? -1: min);
    }
}