import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int[] rows;
    static int result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        rows = new int[N];

        recur(0);
        
        System.out.println(result);
    }

    static void recur(int row){
        if(row == N) {
            result++;
            return;
        }

        for(int i = 0; i < N; i++){
            if(isPossible(row, i)){
                rows[row] = i;
                recur(row + 1);
            }
        }
    }

    static boolean isPossible(int row, int col){
        for(int i = 0; i < row; i++){
            if(rows[i] == col || Math.abs(i - row) == Math.abs(rows[i] - col)) return false;
        }

        return true;
    }
}