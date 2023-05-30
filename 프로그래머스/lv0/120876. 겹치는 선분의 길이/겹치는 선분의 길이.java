class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        
        int start = 100;
        int end = -100;
        
        for(int i = 0; i < lines.length; i++){
            if(lines[i][0] < start) start = lines[i][0];
            if(lines[i][1] > end) end = lines[i][1];
         }
        
        int[] board = new int[end - start];
        
        
        for(int i=0; i<lines.length; i++){
            for(int j = lines[i][0]; j < lines[i][1]; j++){
                if(start > 0 ){
                    board[j-start] += 1;
                }
                else if(start < 0){
                    board[j - start] += 1;
                }
                else board[j] +=1;
                
            }
        }
        
        for(int i=0; i<board.length; i++){
            if(board[i] > 1) answer++;
        }
        return answer;
    }
}