class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        int posX = 0;
        int posY = 0;
        int direction = 0;
        int value = 1;
        
        while(value <= n*n){
            answer[posY][posX] = value++;
            
            if(direction == 0){
                if(posX >= n-1 || answer[posY][posX+1] != 0){
                    posY++;
                    direction = 1;
                }
                else{
                    posX++;
                }
            }
            else if(direction == 1){
                if(posY >= n-1 || answer[posY+1][posX] != 0){
                    posX--;
                    direction = 2;
                }
                else{
                    posY++;
                }
            }
            else if(direction == 2){
                if(posX <= 0 || answer[posY][posX-1] != 0){
                    posY--;
                    direction = 3;
                }
                else{
                    posX--;
                }
            }
            else if(direction == 3){
                if(answer[posY-1][posX] != 0){
                    posX++;
                    direction = 0;
                }
                else{
                    posY--;
                }
            }
        }
        return answer;
    }
}