import java.io.*;
import java.util.*;

public class Main{
    static int[] cnt = new int[2]; // 0 번은 흰색, 1 번은 파란색의 개수 저장
    static int[][] paper;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        paper = new int[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursion(N, 0, 0);
        System.out.printf("%d\n%d",cnt[0], cnt[1]);
    }

    static void recursion(int len, int x, int y){
        if(len == 1 || isFull(len, x, y)) cnt[paper[x][y]]++;
        else{
            int nextLen = len / 2;
            recursion(nextLen, x, y);
            recursion(nextLen, x + nextLen, y);
            recursion(nextLen, x, y + nextLen);
            recursion(nextLen, x + nextLen, y + nextLen);
        }
    }

    static boolean isFull(int len, int x, int y){
        for(int i = x; i < x + len; i++){
            for(int j = y; j < y + len; j++){
                if(paper[x][y] != paper[i][j]) return false;
            }
        }

        return true;
    }
}