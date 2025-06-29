class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        int[][] matrix = new int[board.length + 1][board[0].length + 1];
        
        for(int[] s: skill){
            int degree = s[5] * (s[0] == 1 ? -1 : 1);
            
            matrix[s[1]][s[2]] += degree;
            matrix[s[1]][s[4] + 1] += degree * -1;
            matrix[s[3] + 1][s[2]] += degree * -1;
            matrix[s[3] + 1][s[4] + 1] += degree;
        }
        
        for(int i = 0; i < board.length; i++){
            for(int j = 1; j < board[0].length; j++){
                matrix[i][j] += matrix[i][j - 1];
            }
        }
        
        for(int i = 0; i < board[0].length; i++){
            for(int j = 1; j < board.length; j++){
                matrix[j][i] += matrix[j - 1][i];
            }
        }
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(matrix[i][j] + board[i][j] > 0) answer++;
            }
        }
        
        return answer;
    }
}