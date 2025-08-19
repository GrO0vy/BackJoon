class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        int[][] gameTable = new int[n + 1][n + 1];
        
        for(int[] result: results){
            gameTable[result[0]][result[1]] = 1;
            gameTable[result[1]][result[0]] = -1;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 1; k <= n; k++){
                    if(gameTable[i][j] == 1 && gameTable[j][k] == 1){
                        gameTable[i][k] = 1;
                        gameTable[k][i] = -1;
                    }
                    
                    if(gameTable[i][j] == -1 && gameTable[j][k] == -1){
                        gameTable[i][k] = -1;
                        gameTable[k][i] = 1;
                    }
                }
            }
        }
        
        for(int i = 1; i <= n; i++){
            int cntResult = 0;
            for(int j = 1; j <= n; j++){
                if(gameTable[i][j] != 0) cntResult++;    
            }
            
            if(cntResult == n - 1) answer++;
        }
        
        return answer;
    }
}