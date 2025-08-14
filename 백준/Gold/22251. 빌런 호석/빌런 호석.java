import java.util.*;
import java.io.*;

public class Main{
    static int[][] numbers = {{1, 1, 1, 0, 1, 1, 1}, //0
            {0, 0, 1, 0, 0, 0, 1}, //1
            {0, 1, 1, 1, 1, 1, 0}, //2
            {0, 1, 1, 1, 0, 1, 1}, //3
            {1, 0, 1, 1, 0, 0, 1}, //4
            {1, 1, 0, 1, 0, 1, 1}, //5
            {1, 1, 0, 1, 1, 1, 1}, //6
            {0, 1, 1, 0, 0, 0, 1}, //7
            {1, 1, 1, 1, 1, 1, 1}, //8
            {1, 1, 1, 1, 0, 1, 1}}; //9

    static String format;
    static int[][] cost;
    static int N;
    static int K;
    static int P;
    static String X;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cost = new int[10][10];

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        format = "%0" + K + "d";
        P = Integer.parseInt(st.nextToken());
        X = String.format(format, Integer.parseInt(st.nextToken()));

        for(int i = 0; i < 10; i++){
            for(int j = i + 1; j < 10; j++){
                for(int k = 0; k < 7; k++){
                    if(numbers[i][k] != numbers[j][k]) {
                        cost[i][j]++;
                        cost[j][i]++;
                    }
                }
            }
        }

        int answer = 0;

        for(int i = 1; i <= N; i++){
            String num = String.format(format, i);

            int cntReverse = 0;

            for(int j = 0; j < K; j++){
                cntReverse += cost[X.charAt(j) - '0'][num.charAt(j) - '0'];
            }

            if(cntReverse <= P && cntReverse > 0) answer++;
        }

        System.out.println(answer);
    }
}