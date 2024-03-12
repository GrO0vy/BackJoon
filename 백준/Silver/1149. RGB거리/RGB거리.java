import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] charge = new int [N][3];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                charge[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i < N; i++){
            charge[i][0] += Math.min(charge[i - 1][1], charge[i - 1][2]);
            charge[i][1] += Math.min(charge[i - 1][0], charge[i - 1][2]);
            charge[i][2] += Math.min(charge[i - 1][0], charge[i - 1][1]);
        }

        System.out.println(Math.min(Math.min(charge[N - 1][0], charge[N - 1][1]), charge[N - 1][2]));
    }
}