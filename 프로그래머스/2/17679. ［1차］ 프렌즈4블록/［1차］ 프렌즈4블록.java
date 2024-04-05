import java.util.*;

class Solution {
    int[][] deltas = {{0, 0}, {1, 0}, {0, 1}, {1, 1}};
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] boardArr = new char[m][n];
        
        for(int i = 0; i < board.length; i++){
            boardArr[i] = board[i].toCharArray();
        }
        
        while(true){
            HashSet<int[]> removeBlocks = new HashSet<>();
            
            for(int i = 0; i < m - 1; i++)
                for(int j = 0; j < n - 1; j++)
                    if(boardArr[i][j] != '0')
                        fourBlock(i, j, boardArr, removeBlocks);
           
            if(removeBlocks.isEmpty()) break;
            
            for(int[] remove: removeBlocks) {
                if(boardArr[remove[0]][remove[1]] != '0'){
                    boardArr[remove[0]][remove[1]] = '0';
                    answer++;    
                }
            }
            
            blockDown(boardArr, m, n);
        }
        
        return answer;
    }
    
    void fourBlock(int x, int y, char[][] board, HashSet<int[]> remove){
        for(int[] delta: deltas){
            if(board[x][y] != board[x + delta[0]][y + delta[1]]) return;
        }
        
        for(int[] delta: deltas){
            remove.add(new int[]{x + delta[0], y + delta[1]});
        }
    }
    
    void blockDown(char[][] board, int m, int n){
        for(int i = m - 1; i >= 0; i--){
            for(int j = 0; j < n; j++){
                int curX = i;
                while(curX + 1 < m && 
                      board[curX][j] != '0' &&
                      board[curX + 1][j] == '0')
                {
                    board[curX + 1][j] = board[curX][j];
                    board[curX][j] = '0';
                    curX++;
                }
            }
        }
    }
}