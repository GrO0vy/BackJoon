import java.io.*;
import java.util.*;

public class Main{
    static char[][] chess;
    static int min = 64;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        chess = new char[N][M];
        for(int i = 0; i < N; i++){
            chess[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i <= N - 8; i++){
            for(int j = 0; j <= M - 8; j++){
                calculation(i, j);
            }
        }

        System.out.println(min);
    }

    static void calculation(int startRow, int startCol){
        String[] orgBoard = {"BWBWBWBW", "WBWBWBWB"};

        int cnt = 0;
        for(int i = startRow; i < startRow + 8; i++){
            String orgRow = orgBoard[i % 2];
            for(int j = startCol; j < startCol + 8; j++){
                if(chess[i][j] != orgRow.charAt(j - startCol)) cnt++;
            }
        }

        cnt = Math.min(cnt, 64 - cnt);
        min = Math.min(cnt, min);
    }
}