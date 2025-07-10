import java.util.*;
import java.io.*;

public class Main{
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        int cntApple = Integer.parseInt(br.readLine());
        for(int i = 0; i < cntApple; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
        }

        String[] dirArr = new String[10001];
        int cntDir = Integer.parseInt(br.readLine());

        for(int i = 0; i < cntDir; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            dirArr[Integer.parseInt(st.nextToken())] = st.nextToken();
        }

        int time = 0;
        int[] dir = {0, 1};

        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{0, 0});
        map[0][0] = 2;

        while(true){
            if(dirArr[time] != null){
                if(dirArr[time].equals("L")){
                    if(dir[0] == 0){
                        dir[0] = dir[1] * -1;
                        dir[1] = 0;
                    }
                    else{
                        dir[1] = dir[0];
                        dir[0] = 0;
                    }
                }

                if(dirArr[time].equals("D")){
                    if(dir[0] == 0){
                        dir[0] = dir[1];
                        dir[1] = 0;
                    }
                    else{
                        dir[1] = dir[0] * -1;
                        dir[0] = 0;
                    }
                }
            }

            int[] head = deque.peekLast();

            int nextX = head[0] + dir[0];
            int nextY = head[1] + dir[1];

            if(!inRange(nextX, nextY) || map[nextX][nextY] == 2){
                System.out.println(time + 1);
                return;
            }

            if(map[nextX][nextY] == 0){
                int[] tail = deque.poll();
                map[tail[0]][tail[1]] = 0;
            }

            deque.offer(new int[]{nextX, nextY});
            map[nextX][nextY] = 2;

            time++;
        }
    }

    static private boolean inRange(int x, int y){
        return -1 < x && x < N && -1 < y && y < N;
    }
}