import java.util.*;
class Solution {
    int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int solution(int[][] maps) {
        int answer = bfs(maps);
        return answer;
    }
    
    public int bfs(int[][] maps){
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] isVisited = new boolean[n][m];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        int minTime = -1;
        
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int curX = pos[0];
            int curY = pos[1];
            int time = pos[2];
            
            if(curX == n - 1 && curY == m - 1){
                minTime = time;
                break;
            }
            
            if(isVisited[curX][curY]) continue;
            isVisited[curX][curY] = true;;
            
            for(int[] delta: deltas){
                int nextX = curX + delta[0];
                int nextY = curY + delta[1];
                
                if(inRange(nextX, nextY, n, m) && maps[nextX][nextY] == 1 && !isVisited[nextX][nextY]){
                    queue.add(new int[]{nextX, nextY, time + 1});
                }
            }
        }
        
        return minTime;
    }
    
    public boolean inRange(int x, int y, int n, int m){
        return -1 < x && x < n && -1 < y && y < m;
    }
}