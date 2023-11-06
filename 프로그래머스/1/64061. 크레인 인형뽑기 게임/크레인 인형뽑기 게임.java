import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> bucket = new Stack<>();
        
        for(int move: moves){
            int idx = move - 1;
            int height = 0;
            
            while(height + 1 < board.length && board[height][idx] == 0) height++;
            
            int doll = board[height][idx];
            
            if(doll != 0){
                if(bucket.isEmpty() || bucket.peek() != doll) {
                    bucket.push(doll);
                }
                else{
                    bucket.pop();
                    answer += 2;
                }
                board[height][idx] = 0;
            }
        }
        return answer;
    }
}