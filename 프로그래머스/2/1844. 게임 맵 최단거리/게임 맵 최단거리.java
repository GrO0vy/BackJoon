import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{0, 0, 1});
        
        
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];
            int distance = pos[2];
            
            if(x == maps.length - 1 && y == maps[0].length - 1){
                answer = distance;
                break;
            }
            
            for(int[] delta: deltas){
                int nextX = x + delta[0];
                int nextY = y + delta[1];
                
                if(inRange(maps, nextX, nextY) && maps[nextX][nextY] == 1 && !visited[nextX][nextY]){
                    queue.offer(new int[]{nextX, nextY, distance + 1});
                    visited[nextX][nextY] = true;
                }
            }
        }
        
        return answer;
    }
    
    boolean inRange(int[][] maps, int x, int y){
        return -1 < x && x < maps.length && -1 < y && y < maps[0].length;
    }
}