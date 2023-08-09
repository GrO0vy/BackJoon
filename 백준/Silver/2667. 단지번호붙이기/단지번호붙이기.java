import java.util.*;
import java.io.*;

public class Main{
    int[][] map;
    boolean[][] visited;
    int size = 0;
    int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    List<Integer> result = new ArrayList<>();

    public void solution() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(reader.readLine());
        map = new int[size][size];
        visited = new boolean[size][size];

        for(int i = 0; i < size; i++){
            String mapInfo = reader.readLine();
            for(int j = 0; j < size; j++){
                map[i][j] = Integer.parseInt(String.valueOf(mapInfo.charAt(j)));
            }
        }

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                Queue<int[]> queue = new LinkedList<>();
                int count = 0;
                if(!visited[i][j] && map[i][j] == 1) {
                    int[] next = new int[]{i, j};
                    visited[i][j] = true;
                    queue.offer(next);
                    while(!queue.isEmpty()){
                        int[] pos = queue.poll();
                        int posX = pos[0];
                        int posY = pos[1];
                        count++;

                        for(int[] delta: deltas){
                            int nextX = posX + delta[0];
                            int nextY = posY + delta[1];

                            if(inRange(nextX, nextY)){
                                if(!visited[nextX][nextY] && map[nextX][nextY] == 1) {
                                    queue.offer(new int[]{nextX, nextY});
                                    visited[nextX][nextY] = true;
                                }
                            }
                        }
                    }
                    result.add(count);
                }
            }
        }
        System.out.println(result.size());
        Collections.sort(result);
        for(int i: result) System.out.println(i);
    }

    public boolean inRange(int x, int y){
        return -1 < x && x < size && -1 < y && y < size;
    }
    
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}