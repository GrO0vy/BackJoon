import java.util.*;

class Solution {
    int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int row;
    int col;
    public int solution(String[] board) {
        int answer = -1;
        
        row = board.length;
        col = board[0].length();
        
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length(); j++){
                if(board[i].charAt(j) == 'R') {
                    queue.offer(new int[]{i, j, 0});
                    break;
                }
            }
        }
    
        boolean[][] visited = new boolean[row][col];
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int curX = pos[0];
            int curY = pos[1];
            int cnt = pos[2];
         
            if(board[curX].charAt(curY) == 'G') {
                answer = cnt;
                break;
            }
            
            if(!visited[curX][curY]){
                visited[curX][curY] = true;
                
                for(int[] delta: deltas){
                    int nextX = curX;
                    int nextY = curY;
                    
                    while(inRange(nextX + delta[0], nextY + delta[1]) 
                          && board[nextX + delta[0]].charAt(nextY + delta[1]) != 'D')
                    {
                        nextX += delta[0];
                        nextY += delta[1];
                    }
                    queue.offer(new int[]{nextX, nextY, cnt + 1});
                }
            }
        }
        
        return answer;
    }
    
    boolean inRange(int x, int y){
        return -1 < x && x < row && -1 < y && y < col;    
    }
}