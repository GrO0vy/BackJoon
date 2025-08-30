import java.util.*;

class Solution {
    boolean[][] pillarMap;
    boolean[][] barMap;
    int n;
    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};
        
        this.n = n;
        pillarMap = new boolean[n + 1][n + 1];
        barMap = new boolean[n + 1][n + 1];
        
        int count = 0;
        
        for(int[] build: build_frame){
            int x = build[0];
            int y = build[1];
            int kind = build[2];
            int operation = build[3];
            
            if(kind == 0){
                if(operation == 1){
                    if(checkPillar(x, y)) {
                        pillarMap[x][y] = true;
                        count++;
                    }
                }
                else{
                    pillarMap[x][y] = false;
                    count--;
                    
                    if(!canDelete()) {
                        pillarMap[x][y] = true;
                        count++;
                    }
                }
            }
            else{
                if(operation == 1){
                    if(checkBar(x, y)) {
                        barMap[x][y] = true;
                        count++;
                    }
                }   
                else{
                    barMap[x][y] = false;
                    count--;
                    
                    if(!canDelete()) {
                        barMap[x][y] = true;
                        count++;
                    }
                }
            }
        }
        
        answer = new int[count][3];
        int idx = 0;
        
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
                if(pillarMap[i][j]){
                    answer[idx++] = new int[]{i, j, 0};    
                }
                if(barMap[i][j]){
                    answer[idx++] = new int[]{i, j, 1};
                }
            }
        }
        
        Arrays.sort(answer, (o1, o2) ->{
            if(o1[0] != o2[0]) return o1[0] - o2[0];
            if(o1[1] != o2[1]) return o1[1] - o2[1];
            
            return o1[2] - o2[2];
        });
        
        return answer;
    }
    
    private boolean checkPillar(int x, int y){
        if(y == 0) return true;
        if(x > 0 && barMap[x - 1][y] || barMap[x][y]) return true;
        if(y > 0 && pillarMap[x][y - 1]) return true;
        
        return false;
    }
    
    private boolean checkBar(int x, int y){
        if(y > 0 && pillarMap[x][y - 1] || pillarMap[x + 1][y - 1]) return true;
        if(x > 0 && barMap[x - 1][y] && barMap[x + 1][y]) return true;
        
        return false;
    }
    
    private boolean canDelete(){
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
                if(pillarMap[i][j] && !checkPillar(i, j)) return false;
                if(barMap[i][j] && !checkBar(i, j)) return false;
            }
        }
        
        return true;
    }
}