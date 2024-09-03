import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Pos[][] map = new Pos[N + 1][N + 1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                map[i][j] = new Pos(i, j);
            }
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int nextX = Integer.parseInt(st.nextToken());
            int nextY = Integer.parseInt(st.nextToken());

            map[x][y].add(map[nextX][nextY]);
        }

        boolean[][] isLight = new boolean[N + 1][N + 1];
        boolean[][] visited = new boolean[N + 1][N + 1];
        isLight[1][1] = true;
        visited[1][1] = true;

        int result = 1;

        Queue<Pos> queue = new LinkedList<>();
        queue.offer(map[1][1]);

        while(!queue.isEmpty()){
            Pos cur = queue.poll();
            List<Pos> connectedRooms = cur.connected;

            for(Pos connectedRoom : connectedRooms){
                if(!isLight[connectedRoom.x][connectedRoom.y]){
                    isLight[connectedRoom.x][connectedRoom.y] = true;

                    for(int[] delta: deltas){
                        int nextX = delta[0] + connectedRoom.x;
                        int nextY = delta[1] + connectedRoom.y;

                        if(inRange(nextX, nextY) && visited[nextX][nextY]){
                            queue.offer(connectedRoom);
                            visited[connectedRoom.x][connectedRoom.y] = true;
                            break;
                        }
                    }
                    result++;
                }
            }
            
            for(int[] delta: deltas){
                int nextX = cur.x + delta[0];
                int nextY = cur.y + delta[1];

                if(inRange(nextX, nextY) && isLight[nextX][nextY] && !visited[nextX][nextY]){
                    queue.offer(map[nextX][nextY]);
                    visited[nextX][nextY] = true;
                }
            }
        }

        System.out.println(result);
    }

    static boolean inRange(int x, int y){
        return 0 < x && x <= N && 0 < y && y <= N;
    }

    static class Pos{
        int x;
        int y;
        List<Pos> connected;

        public Pos(int x, int y){
            this.x = x;
            this.y = y;
            connected = new ArrayList<>();
        }

        public void add(Pos next){
            connected.add(next);
        }
    }
}