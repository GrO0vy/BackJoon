import java.io.*;
import java.util.*;

public class Main{
    static int[][] deltas = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, -1}, {2, 1}, {-2, 1}, {-2, -1}};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++){
            int l = Integer.parseInt(br.readLine());
            int[][] chess = new int[l][l];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] start = new int[3];
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());

            int[] destination = new int[2];
            st = new StringTokenizer(br.readLine());
            destination[0] = Integer.parseInt(st.nextToken());
            destination[1] = Integer.parseInt(st.nextToken());

            sb.append(bfs(start, destination, chess) + "\n");
        }

        System.out.println(sb);
    }

    static int bfs(int[] start, int[] destination, int[][] chess) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);

        int desX = destination[0];
        int desY = destination[1];

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int curX = pos[0];
            int curY = pos[1];
            int cnt = pos[2];

            if (curX == desX && curY == desY) return cnt;

            if (chess[curX][curY] == 1) continue;

            chess[curX][curY] = 1;

            for (int[] delta : deltas) {
                int nextX = curX + delta[0];
                int nextY = curY + delta[1];

                if (inRange(nextX, nextY, chess) && chess[nextX][nextY] == 0) {
                    queue.offer(new int[]{nextX, nextY, cnt + 1});
                }
            }
        }

        return -1;
    }

    static boolean inRange(int x, int y, int[][] chess){
        int max = chess.length;

        return -1 < x && x < max && -1 < y && y < max;
    }
}
