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
            HashSet<String> removeBlocks = new HashSet<>();
            
            for(int i = 0; i < m - 1; i++)
                for(int j = 0; j < n - 1; j++)
                    if(boardArr[i][j] != '0')
                        fourBlock(i, j, boardArr, removeBlocks);
                
            // for(int[] a: removeBlocks){
            //     System.out.println(a[0] + " " + a[1]);
            // }
            // System.out.println("==============");
            if(removeBlocks.isEmpty()) break;
            
            for(String remove: removeBlocks) {
                String pos[] = remove.split(" ");
                boardArr[Integer.parseInt(pos[0])][Integer.parseInt(pos[1])] = '0';
                answer++;
            }
            
            blockDown(boardArr, m, n);
        }
        
        return answer;
    }
    
    void fourBlock(int x, int y, char[][] board, HashSet<String> remove){
        for(int[] delta: deltas){
            if(board[x][y] != board[x + delta[0]][y + delta[1]]) return;
        }
        
        for(int[] delta: deltas){
            remove.add((x + delta[0]) + " " + (y + delta[1]));
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