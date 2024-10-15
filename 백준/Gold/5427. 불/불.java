import java.util.*;
import java.io.*;

public class Main{
    static int height;
    static int width;
    static char[][] map;
    static boolean[][] visited;
    static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            map = new char[height][width];
            visited = new boolean[height][width];

            Queue<Pos> person = new LinkedList<>();
            Queue<Pos> fire = new LinkedList<>();

            for(int j = 0; j < height; j++){
                String row = br.readLine();
                for(int k = 0; k < width; k++){
                    map[j][k] = row.charAt(k);
                    if(row.charAt(k) == '@') {
                        person.offer(new Pos(j, k, 0));
                        map[j][k] = '.';
                    }
                    if(row.charAt(k) == '*') fire.offer(new Pos(j, k, 0));
                }
            }

            sb.append(bfs(person, fire) + "\n");
        }

        System.out.println(sb);
    }

    static String bfs(Queue<Pos> person, Queue<Pos> fire){
        int result = -1;

        while(!person.isEmpty()){
            int cntPerson = person.size();
            int cntFire = fire.size();

            for(int i = 0; i < cntFire; i++){
                Pos f = fire.poll();

                for(int[] delta: deltas){
                    int nextX = f.x + delta[0];
                    int nextY = f.y + delta[1];

                    if(inRange(nextX, nextY) && map[nextX][nextY] == '.') {
                        map[nextX][nextY] = '*';
                        fire.offer(new Pos(nextX, nextY, f.time + 1));
                    }
                }
            }

            for(int i = 0; i < cntPerson; i++){
                Pos cur = person.poll();

                if(isEscape(cur.x, cur.y)){
                    person.clear();
                    result = cur.time + 1;
                    break;
                }

                for(int[] delta: deltas){
                    int nextX = cur.x + delta[0];
                    int nextY = cur.y + delta[1];

                    if(inRange(nextX, nextY) && map[nextX][nextY] == '.' && !visited[nextX][nextY]){
                        person.offer(new Pos(nextX, nextY, cur.time + 1));
                        visited[nextX][nextY] = true;
                    }
                }
            }

        }

        return result == -1 ? "IMPOSSIBLE" : String.valueOf(result);
    }

    static boolean inRange(int x, int y){
        return -1 < x && x < height && -1 < y && y < width;
    }

    static boolean isEscape(int x, int y){
        return x == 0 || x == height -1 || y == 0 || y == width - 1;
    }

    static class Pos{
        int x;
        int y;
        int time;

        public Pos(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}