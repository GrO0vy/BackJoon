class Solution {
    int[][] board;
    int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        int answer = 0;
        this.board = board;
        
        answer = dfs(aloc[0], aloc[1], bloc[0], bloc[1]);
        
        return answer;
    }
    
    int dfs(int playerX, int playerY, int opponentX, int opponentY){
        if(board[playerX][playerY] == 0) return 0;
        
        int result = 0;
        
        for(int[] delta: deltas){
            int nextX = playerX + delta[0];
            int nextY = playerY + delta[1];
            
            if(!inRange(nextX, nextY) || board[nextX][nextY] == 0) continue;
            
            board[playerX][playerY] = 0;
            int moveCount = dfs(opponentX, opponentY, nextX, nextY) + 1;
            board[playerX][playerY] = 1;
            
            if(result % 2 == 0 && moveCount % 2 == 0){
                result = Math.max(result, moveCount);
            }
            else if(result % 2  == 0 && moveCount % 2 == 1){
                result = moveCount;
            }
            else if(result % 2 == 1 && moveCount % 2 == 1){
                result = Math.min(result, moveCount);
            }
        }
        
        return result;
    }
    
    boolean inRange(int x, int y){
        return -1 < x && x < board.length && -1 < y && y < board[0].length;
    }
}