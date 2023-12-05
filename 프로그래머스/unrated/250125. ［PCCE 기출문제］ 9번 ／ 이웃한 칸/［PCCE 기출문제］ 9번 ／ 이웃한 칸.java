class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int length = board.length;
        int count = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        String color = board[h][w];
        
        for(int i = 0; i < 4; i++){
            int x = h + dx[i];
            int y = w + dy[i];
            
            if(inRange(x, y, length) && color.equals(board[x][y])) count++;
            
        }
        
        answer = count;
        
        return answer;
    }
    
    boolean inRange(int x, int y, int length){
        return -1 < x && x < length && -1 < y && y < length;
    }
}