import java.util.*;
import java.io.*;

public class Main{
    static int[][] cctv = {{0, 1, 0, 0}, {0, 1, 0, 1}, {1, 1, 0, 0}, {1, 1, 0, 1}, {1, 1, 1, 1}};
    static int N;
    static int M;
    static int cntTv;
    static int[][] map;
    static List<int[]> pos;
    static int result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        result = N * M;

        pos = new ArrayList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                int value = Integer.parseInt(st.nextToken());

                if(value == 0) continue;

                if(value == 6) map[i][j] = value;
                else {
                    map[i][j] = -1;
                    pos.add(new int[]{i, j, value - 1});
                    cntTv++;
                }
            }
        }

        dfs(0);

        System.out.println(result);
    }

    static void dfs(int count){
        if(count == cntTv){
            int cntFree = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(map[i][j] == 0) cntFree++;
                }
            }

            result = Math.min(result, cntFree);

            return;
        }

        int[] current = pos.get(count);
        int x = current[0];
        int y = current[1];
        int tvNum = current[2];

        int[] dir = cctv[tvNum];

        int[][] origin = new int[N][M];
        for(int i = 0; i < N; i++) origin[i] = map[i].clone();

        for(int i = 0; i < 4; i++){
            int first = dir[0];

            for(int j = 1; j < dir.length; j++){
                dir[j - 1] = dir[j];
            }

            dir[dir.length - 1] = first;

            if(dir[0] == 1){
                int idx = x - 1;
                while(idx >= 0 && map[idx][y] != 6){
                    map[idx][y] = -1;
                    idx--;
                }
            }

            if(dir[1] == 1){
                int idx = y + 1;
                while(idx < M && map[x][idx] != 6){
                    map[x][idx] = -1;
                    idx++;
                }
            }

            if(dir[2] == 1){
                int idx = x + 1;
                while(idx < N && map[idx][y] != 6){
                    map[idx][y] = -1;
                    idx++;
                }
            }

            if(dir[3] == 1){
                int idx = y - 1;
                while(idx >= 0 && map[x][idx] != 6){
                    map[x][idx] = -1;
                    idx--;
                }
            }

            dfs(count + 1);

            for(int j = 0; j < N; j++) map[j] = origin[j].clone();
        }
    }
}