import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int M;
    static int[][] map;
    static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        
        for(int i = 0; i < M; i++){
            String row = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = row.charAt(j) - '0';
            }
        }
        
        System.out.println(cntMinBreak());
    }
    
    static int cntMinBreak(){
        int[][] cntBreak = new int[M][N];
        for(int i = 0; i < M; i++) Arrays.fill(cntBreak[i], Integer.MAX_VALUE);
        cntBreak[0][0] = 0;
        
        boolean[][] visited = new boolean[M][N];
        
        PriorityQueue<Pos> pq = new PriorityQueue<>((o1, o2) ->{
            return cntBreak[o1.x][o1.y] - cntBreak[o2.x][o2.y];
        });
        pq.offer(new Pos(0, 0, 0));
        
        while(!pq.isEmpty()){
            Pos current = pq.poll();
            
            if(visited[current.x][current.y]) continue;
            visited[current.x][current.y] = true;
            
            for(int[] delta: deltas){
                int nextX = current.x + delta[0];
                int nextY = current.y + delta[1];
                int nextBreak = current.cntBreak;

                if(!inRange(nextX, nextY)) continue;

                if(map[nextX][nextY] == 1) nextBreak++;
                
                if(nextBreak < cntBreak[nextX][nextY]){
                    cntBreak[nextX][nextY] = nextBreak;
                    pq.offer(new Pos(nextX, nextY, nextBreak));
                }
            }
        }
        
        return cntBreak[M - 1][N - 1];
    }

    static boolean inRange(int x, int y){
        return -1 < x && x < M && -1 < y && y < N;
    }
    
    static class Pos{
        int x;
        int y;
        int cntBreak;
        
        public Pos(int x, int y, int cntBreak){
            this.x = x;
            this.y = y;
            this.cntBreak = cntBreak;
        }
    }
}