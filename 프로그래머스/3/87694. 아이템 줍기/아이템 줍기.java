import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        int[][] map = new int[101][101];
        
        for(int[] r: rectangle){
            int xBottom = r[0] * 2;
            int xTop = r[2] * 2;
            int yLeft = r[1] * 2;
            int yRight = r[3] * 2;
            
            for(int i = xBottom; i <= xTop; i++){
                for(int j = yLeft; j <= yRight; j++){
                    if(i == xBottom || i == xTop || j == yLeft || j == yRight)
                    {
                        if(map[i][j] == 0) map[i][j] = 1; 
                    }
                    else map[i][j] = 2;
                }
            }
        }
        
        int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1 ,0}};
        boolean[][] visited = new boolean[101][101];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{characterX * 2, characterY * 2, 0});
        
        visited[characterX * 2][characterY * 2] = true;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            
            for(int[] delta: deltas){
                int nextX = current[0] + delta[0];
                int nextY = current[1] + delta[1];
                int nextDistance = current[2] + 1;
                
                if(nextX == itemX * 2 && nextY == itemY * 2) return (current[2] + 1) / 2;
                
                if(inRange(nextX, nextY) && !visited[nextX][nextY] && map[nextX][nextY] == 1)
                {
                    queue.offer(new int[]{nextX, nextY, nextDistance});
                    visited[nextX][nextY] = true;
                }
            }
        }
        
        return -1;
    }
    
    boolean inRange(int x, int y){
        return 0 < x && x < 101 && 0 < y && y < 101;
    }
}