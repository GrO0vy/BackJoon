class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int size = board.length;
        boolean[][] isDanger = new boolean[size][size];
        int[] x = {-1, -1, -1, 0, 0, 0 ,1 ,1 ,1};
        int[] y = {-1, 0, 1, -1, 0, 1, -1, 0 ,1};
        
        for(int i=0; i <size; i++){
            for(int j = 0; j < size; j++){
                if( board[i][j] == 1 ){
                    for(int k=0; k<9; k++){
                        int posY = i+x[k];
                        int posX = j+y[k];
                        if(posY >= 0 && posY < size && posX >= 0 && posX < size){
                            isDanger[posY][posX] = true;
                        }
                    }
                }
            }
        }
        for(int i = 0; i < size; i++){
                for(int j =0; j <size; j++){
                    if(!isDanger[i][j]) answer++;
                }
            }
        return answer;
    }
}