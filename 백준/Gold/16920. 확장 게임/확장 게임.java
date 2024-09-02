import java.util.*;
import java.io.*;

public class Main {
    static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static char[][] map;

    static int N;
    static int M;
    static int[] cnt;

    static int[] move;

    static List<Pos>[] startPoints;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        cnt = new int[P + 1];
        move = new int[P + 1];

        startPoints = new ArrayList[P + 1];
        for(int i = 1; i <= P; i++) startPoints[i] = new ArrayList<>();

        map = new char[N][M];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= P; i++) {
            move[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] != '#' && map[i][j] != '.') {
                    startPoints[map[i][j] - '0'].add(new Pos(i, j, 0));
                    cnt[map[i][j] - '0']++;
                }
            }
        }

        while (true) {
            boolean isEnd = true;

            for (int i = 1; i <= P; i++) {
                isEnd = bfs(i) && isEnd;
            }

            if (isEnd) break;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= P; i++) sb.append(cnt[i] + " ");
        
        System.out.println(sb);
    }


    static boolean bfs(int idx) {
        Queue<Pos> queue = new LinkedList<>();
        for(Pos p: startPoints[idx]) queue.offer(p);
        startPoints[idx].clear();

        while(!queue.isEmpty()){
            Pos cur = queue.poll();
            
            if(cur.dis == move[idx]){
                startPoints[idx].add(new Pos(cur.x, cur.y, 0));
                continue;
            }

            for(int[] delta: deltas){
                int nextX = delta[0] + cur.x;
                int nextY = delta[1] + cur.y;

                if(inRange(nextX, nextY) && map[nextX][nextY] =='.' && cur.dis < move[idx]){
                    map[nextX][nextY] = (char)((int)'0' + idx);
                    queue.offer(new Pos(nextX, nextY, cur.dis + 1));
                    cnt[idx]++;
                }
            }
        }

        return startPoints[idx].isEmpty();
    }

    static boolean inRange(int x, int y) {
        return -1 < x && x < N && -1 < y && y < M;
    }

    static class Pos {
        int x;
        int y;
        int dis;

        public Pos(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }


}