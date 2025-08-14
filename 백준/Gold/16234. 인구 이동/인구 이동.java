import java.util.*;
import java.io.*;

public class Main{
    static final int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[][] map;
    static int N;
    static int L;
    static int R;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;

        while(true){
            boolean[][] visited = new boolean[N][N];

            int cntFederation = 0;

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(!visited[i][j]) {
                        visited[i][j] = true;
                        cntFederation += bfs(i, j, visited);
                    }
                }
            }

            if(cntFederation == 0) break;

            result++;
        }

        System.out.println(result);
    }

    static int bfs(int x, int y, boolean[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        List<int[]> adjList = new ArrayList<>();
        int cntPeople = 0;
        int cntCountry = 0;

        while(!queue.isEmpty()){
            int[] current = queue.poll();

            cntPeople += map[current[0]][current[1]];
            cntCountry++;
            adjList.add(current);

            for(int[] delta: deltas){
                int nextX = current[0] + delta[0];
                int nextY = current[1] + delta[1];

                if(inRange(nextX, nextY) && !visited[nextX][nextY] && canMove(current[0], current[1], nextX, nextY)){
                    queue.offer(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }

        int people = cntPeople / cntCountry;

        for(int[] country: adjList){
            map[country[0]][country[1]] = people;
        }

        return cntCountry > 1 ? 1 : 0;
    }

    static boolean inRange(int x, int y){
        return -1 < x && x < N && -1 < y && y < N;
    }

    static boolean canMove(int x1, int y1, int x2, int y2){
        int country1 = map[x1][y1];
        int country2 = map[x2][y2];

        int diff = Math.abs(country1 - country2);

        return L <= diff && diff <= R;
    }
}