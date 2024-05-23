class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;

        if(board.length == 1 || board[0].length == 1) answer = 1;
        else{
            for(int i = 0; i < board.length - 1; i++){
                for(int j = 0; j < board[0].length - 1; j++){
                    answer = (int)Math.max(answer, Math.pow(square(board, i, j), 2));
                }
            }    
        }

        return answer;
    }
    
    int square(int[][] board, int x, int y){
        int min = Integer.MAX_VALUE;
        
        if(board[x + 1][y + 1] == 1){
            min = Math.min(min, board[x][y]);
            min = Math.min(min, board[x + 1][y]);
            min = Math.min(min, board[x][y + 1]);
            
            board[x + 1][y + 1] = min + 1;
        }
        
        return board[x + 1][y + 1];
    }
}