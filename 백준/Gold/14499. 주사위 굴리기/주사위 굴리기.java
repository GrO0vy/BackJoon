import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dice = {0, 0, 0, 0, 0, 0};
        int[] width = {3, 0, 2, 5};
        int[] height = {1, 0, 4, 5};

        int x = startX;
        int y = startY;

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < K; i++){
            int dir = Integer.parseInt(st.nextToken());

            switch(dir){
                case 1:
                    if(inRange(x, y + 1)){
                        int last = width[3];

                        for(int j = 2; j >= 0; j--){
                            width[j + 1] = width[j];
                        }

                        width[0] = last;

                        height[1] = width[1];
                        height[3] = width[3];

                        if(map[x][++y] == 0){
                            map[x][y] = dice[width[1]];
                        }
                        else{
                            dice[width[1]] = map[x][y];
                            map[x][y] = 0;
                        }

                        System.out.println(dice[width[3]]);
                    }

                    break;

                case 2:
                    if(inRange(x, y - 1)){
                        int first = width[0];

                        for(int j = 1; j < 4; j++){
                            width[j - 1] = width[j];
                        }

                        width[3] = first;

                        height[1] = width[1];
                        height[3] = width[3];

                        if(map[x][--y] == 0){
                            map[x][y] = dice[width[1]];
                        }
                        else{
                            dice[width[1]] = map[x][y];
                            map[x][y] = 0;
                        }

                        System.out.println(dice[width[3]]);
                    }

                    break;

                case 3:
                    if(inRange(x - 1, y)){
                        int first = height[0];

                        for(int j = 1; j < 4; j++){
                            height[j - 1] = height[j];
                        }

                        height[3] = first;

                        width[1] = height[1];
                        width[3] = height[3];

                        if(map[--x][y] == 0){
                            map[x][y] = dice[height[1]];
                        }
                        else{
                            dice[height[1]] = map[x][y];
                            map[x][y] = 0;
                        }

                        System.out.println(dice[height[3]]);
                    }

                    break;

                case 4:
                    if(inRange(x + 1, y)){
                        int last = height[3];

                        for(int j = 2; j >= 0; j--){
                            height[j + 1] = height[j];
                        }

                        height[0] = last;

                        width[1] = height[1];
                        width[3] = height[3];

                        if(map[++x][y] == 0){
                            map[x][y] = dice[height[1]];
                        }
                        else{
                            dice[height[1]] = map[x][y];
                            map[x][y] = 0;
                        }

                        System.out.println(dice[height[3]]);
                    }

                    break;
            }
        }

    }

    static private boolean inRange(int x, int y){
        return -1 < x && x < N && -1 < y && y < M;
    }
}