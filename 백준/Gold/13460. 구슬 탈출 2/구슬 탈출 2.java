import java.io.*;
import java.util.*;

public class Main{
    static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        char[][] map = new char[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];

        int[] red = {};
        int[] blue = {};

        for(int i = 0; i < map.length; i++){
            String row = br.readLine();
            for(int j = 0; j < map[0].length; j++){
                map[i][j] = row.charAt(j);
                if(map[i][j] == 'R') red = new int[]{i, j};
                if(map[i][j] == 'B') blue = new int[]{i, j};
            }
        }

        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(red[0], red[1], blue[0], blue[1], 0));

        while(!queue.isEmpty()){
            Pos current = queue.poll();

            if(current.moveCount >= 10) break;

            for(int[] delta: deltas){
                int nextBlueX = current.blueX;
                int nextBlueY = current.blueY;

                while(map[nextBlueX + delta[0]][nextBlueY + delta[1]] != '#'){
                    nextBlueX += delta[0];
                    nextBlueY += delta[1];

                    if(map[nextBlueX][nextBlueY] == 'O') break;
                }

                if(map[nextBlueX][nextBlueY] == 'O') continue;

                int nextRedX = current.redX;
                int nextRedY = current.redY;

                while(map[nextRedX + delta[0]][nextRedY + delta[1]] != '#'){
                    nextRedX += delta[0];
                    nextRedY += delta[1];

                    if(map[nextRedX][nextRedY] == 'O') break;
                }

                if(map[nextRedX][nextRedY] == 'O'){
                    System.out.println(current.moveCount + 1);
                    return;
                }

                if(nextRedX == nextBlueX && nextRedY == nextBlueY){
                    if(delta[0] == 1){
                        if(current.redX > current.blueX) nextBlueX--;
                        else nextRedX--;
                    }
                    else if(delta[0] == -1){
                        if(current.redX > current.blueX) nextRedX++;
                        else nextBlueX++;
                    }
                    else if(delta[1] == 1){
                        if(current.redY > current.blueY) nextBlueY--;
                        else nextRedY--;
                    }
                    else{
                        if(current.redY > current.blueY) nextRedY++;
                        else nextBlueY++;
                    }
                }

                queue.offer(new Pos(nextRedX, nextRedY, nextBlueX, nextBlueY, current.moveCount + 1));
            }
        }

        System.out.println(-1);
    }
}

class Pos{
    int redX;
    int redY;
    int blueX;
    int blueY;
    int moveCount;

    public Pos(int redX, int redY, int blueX, int blueY, int moveCount){
        this.redX = redX;
        this.redY = redY;
        this.blueX = blueX;
        this.blueY = blueY;
        this.moveCount = moveCount;
    }
}