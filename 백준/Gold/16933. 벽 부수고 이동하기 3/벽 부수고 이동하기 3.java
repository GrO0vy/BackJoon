    import java.util.*;
    import java.io.*;

    public class Main {
        static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        static int N;
        static int M;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            char[][] map = new char[N][M];
            for (int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
            }

            boolean[][][][] visited = new boolean[N][M][K + 1][2];

            Queue<Pos> queue = new LinkedList<>();
            queue.offer(new Pos(0, 0, 1, K, 1));
            visited[0][0][0][0] = true;

            int result = -1;
            while (!queue.isEmpty()) {
                Pos current = queue.poll();

                if (current.x == N - 1 && current.y == M - 1) {
                    result = current.dis;
                    break;
                }

                for (int[] delta : deltas) {
                    int nextX = current.x + delta[0];
                    int nextY = current.y + delta[1];

                    if (inRange(nextX, nextY)) {
                        if (map[nextX][nextY] == '0') {
                            if (current.isDay == 1 && !visited[nextX][nextY][current.cntBreak][current.isDay - 1]) {
                                queue.offer(new Pos(nextX, nextY, current.dis + 1, current.cntBreak, current.isDay - 1));
                                visited[nextX][nextY][current.cntBreak][current.isDay - 1] = true;
                            }
                            else if(current.isDay == 0 && !visited[nextX][nextY][current.cntBreak][current.isDay]){
                                queue.offer(new Pos(nextX, nextY, current.dis + 1, current.cntBreak, current.isDay + 1));
                                visited[nextX][nextY][current.cntBreak][current.isDay + 1] = true;
                            }
                        } else {
                            if (current.cntBreak > 0) {
                                if (current.isDay == 1) {
                                    if (!visited[nextX][nextY][current.cntBreak - 1][current.isDay - 1]) {
                                        queue.offer(new Pos(nextX, nextY, current.dis + 1, current.cntBreak - 1, current.isDay - 1));
                                        visited[nextX][nextY][current.cntBreak - 1][current.isDay - 1] = true;
                                    }
                                }
                                else {
                                    if (!visited[current.x][current.y][current.cntBreak][current.isDay + 1]) {
                                        queue.offer(new Pos(current.x, current.y, current.dis + 1, current.cntBreak, current.isDay + 1));
                                        visited[current.x][current.y][current.cntBreak][current.isDay + 1] = true;
                                    }
                                }
                            }
                        }

                    }
                }
            }

            System.out.println(result);
        }

        static boolean inRange(int x, int y) {
            return -1 < x && x < N && -1 < y && y < M;
        }

        static class Pos {
            int x;
            int y;
            int dis;
            int cntBreak;

            int isDay;

            public Pos(int x, int y, int dis, int cntBreak, int isDay) {
                this.x = x;
                this.y = y;
                this.dis = dis;
                this.cntBreak = cntBreak;
                this.isDay = isDay;
            }
        }
    }