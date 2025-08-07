import java.util.*;

class Solution {
    int[] deltaX = {-1, 1, 0, 0};
    int[] deltaY = {0, 0, 1, -1};
    int size;
    
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        size = board.length;
        
        boolean[][][] visited = new boolean[4][size][size];
        
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(0, 0, -1, 0));
        visited[0][0][0] = true;
        visited[1][0][0] = true;
        visited[2][0][0] = true;
        visited[3][0][0] = true;
         
        while(!queue.isEmpty()){
            Pos current = queue.poll();
            
            for(int i = 0; i < 4; i++){
                int nextX = current.x + deltaX[i];
                int nextY = current.y + deltaY[i];
                
                if(!inRange(nextX, nextY) || board[nextX][nextY] == 1) continue;
                
                int nextCost = current.cost;
                
                if(current.delta == -1 || current.delta == i){
                    nextCost += 100;
                }
                else nextCost += 600;
                
                if(nextX == size - 1 && nextY == size - 1){
                    answer = Math.min(answer, nextCost);
                    continue;
                }
                
                if(!visited[i][nextX][nextY]|| board[nextX][nextY] >= nextCost){
                    visited[i][nextX][nextY] = true;
                    board[nextX][nextY] = nextCost;
                    queue.offer(new Pos(nextX, nextY, i, nextCost));   
                }
            }
        }
        
        return answer;
    }
    
    boolean inRange(int x, int y){
        return -1 < x && x < size && -1 < y && y < size;    
    }
    
    class Pos{
        int x;
        int y;
        int delta;
        int cost;
        
        public Pos(int x, int y, int delta, int cost){
            this.x = x;
            this.y = y;
            this.delta = delta;
            this.cost = cost;
        }
    }
}