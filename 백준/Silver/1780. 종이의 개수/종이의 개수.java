import java.io.*;
import java.util.*;

public class Main{
    static int[] cnt = new int[3];

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

        recursion(0, 0, N);
        System.out.printf("%d\n%d\n%d",cnt[0], cnt[1], cnt[2]);
    }

    static void recursion(int x, int y, int length){
        if(length == 1) {
            cnt[paper[x][y] + 1]++;
            return;
        }

        int flag = isAllSame(x, y, length);
        if(flag < 3) cnt[flag]++;
        else{
            int nextLen = length / 3;
            for(int i = x; i < x + length; i += nextLen){
                for(int j = y; j < y + length; j+= nextLen){
                    recursion(i, j, nextLen);
                }
            }
        }
    }

    static int isAllSame(int x, int y, int length){
        int standard = paper[x][y];
        for(int i = x; i < x + length; i++){
            for(int j = y; j < y + length; j++){
                if(standard != paper[i][j]) return 3;
            }
        }

        return standard + 1;
    }
}