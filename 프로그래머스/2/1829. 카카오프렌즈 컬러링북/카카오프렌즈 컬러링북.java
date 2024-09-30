import java.util.*;

class Solution {
    int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int row;
    int col;
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        row = m;
        col = n;
        
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && picture[i][j] > 0){
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(i, j, visited, picture));
                }        
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    int bfs(int x, int y, boolean[][] visited, int[][] picture){
        int color = picture[x][y];
        int area = 1;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int curX = pos[0];
            int curY = pos[1];
            
            for(int[] delta: deltas){
                int nextX = curX + delta[0];
                int nextY = curY + delta[1];
                
                if(inRange(nextX, nextY) && !visited[nextX][nextY] && picture[nextX][nextY] == color){
                    queue.offer(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                    area++;
                }
            }
        }
        
        return area;
    }
    
    boolean inRange(int x, int y){
        return -1 < x && x < row && -1 < y && y < col;    
    }
}