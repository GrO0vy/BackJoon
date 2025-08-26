import java.util.*;

class Solution {
    final char[] dir = {'d', 'l', 'r', 'u'};
    final int[][] delta = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
    
    int[][] map;
    int[] start;
    int[] destination;
    int distance;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        
        map = new int[n][m];
        
        start = new int[]{x - 1, y - 1};
        destination = new int[]{r - 1, c - 1};
        
        distance = k;
        
        return bfs();
    }
    
    String bfs(){
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(start[0], start[1], 0, ""));
        
        boolean[][][] visited = new boolean [distance][map.length][map[0].length];
        visited[0][start[0]][start[1]] = true;
        
        while(!queue.isEmpty()){
            Pos current = queue.poll();
            
            for(int i = 0; i < 4; i++){
                int nextX = current.x + delta[i][0];
                int nextY = current.y + delta[i][1];
                
                if(!inRange(nextX, nextY)) continue;
                
                int nextCntMove = current.cntMove + 1;
                String nextMovement = current.movement + dir[i];
                
                if(nextCntMove == distance){
                    if(nextX == destination[0] && nextY == destination[1]){
                        return nextMovement;    
                    }
                }
                else{
                    if(!visited[nextCntMove][nextX][nextY]){
                        visited[nextCntMove][nextX][nextY] = true;
                        queue.offer(new Pos(nextX, nextY, nextCntMove, nextMovement));    
                    }
                }
            }
        }
        
        return "impossible";
    }
    
    boolean inRange(int x, int y){
        return -1 < x && x < map.length && -1 < y && y < map[0].length;    
    }
    
    class Pos{
        int x;
        int y;
        int cntMove;
        String movement;
        
        public Pos(int x, int y, int cntMove, String movement){
            this.x = x;
            this.y = y;
            this.cntMove = cntMove;
            this.movement = movement;
        }
    }
}