import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] minCharge = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i != j) minCharge[i][j] = 200000000;
            }
        }

        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            minCharge[start][end] = Math.min(minCharge[start][end], weight);
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 1; k <= n; k++){
                    minCharge[j][k] = Math.min(minCharge[j][k], minCharge[j][i] + minCharge[i][k]);
                }
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <=n; j++){
                if(minCharge[i][j] == 200000000) System.out.print(0 + " ");
                else System.out.print(minCharge[i][j] + " ");
            }
            System.out.println();
        }
    }
}