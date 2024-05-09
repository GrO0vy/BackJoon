import java.util.*;

class Solution {
    int[][] deltas =  {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        Arrays.fill(answer, 1);
        
        for(int i = 0; i < 5; i++){
            boolean flag = true;
            for(int j = 0; j < 5; j++){
                for(int k = 0; k < 5; k++){
                    if(places[i][j].charAt(k) == 'P' 
                       && !isComplete(j, k, places[i]))
                    {
                        answer[i] = 0;
                        flag = false;
                        break;
                    }
                }
                if(!flag) break;
            }
        }
        
        return answer;
    }
    
    boolean isComplete(int x, int y, String[] map){
        boolean[][] visited = new boolean[5][5];
        visited[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, 0});
        
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int curX = pos[0];
            int curY = pos[1];
            int distance = pos[2];
            
            if(!(curX == x && curY == y) && map[curX].charAt(curY) == 'P')
                return false;
             
            for(int[] delta: deltas){
                int nextX = curX + delta[0];
                int nextY = curY + delta[1];
                
                if(inRange(nextX, nextY) && map[nextX].charAt(nextY) != 'X' 
                   && !visited[nextX][nextY] && distance < 2)
                {
                    visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY, distance + 1});      
                }
            }
        }
        
        return true;
    }
    
    boolean inRange(int x, int y){
        return -1 < x && x < 5 && -1 < y && y < 5;
    }
}