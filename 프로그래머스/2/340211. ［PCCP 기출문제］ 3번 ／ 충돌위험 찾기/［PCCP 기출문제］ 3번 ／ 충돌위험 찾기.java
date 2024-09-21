class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        int[][][] count = new int[101][101][20001];
        
        for(int[] route: routes){
            int[] start = points[route[0] - 1];
            int startX = start[0];
            int startY = start[1];
            
            int time = 0;
            
            count[startX][startY][time]++;
            
            for(int i = 1; i < route.length; i++){
                int[] des = points[route[i] - 1];
                
                int deltaX = delta(startX, des[0]);
                int deltaY = delta(startY, des[1]);
                
                while(startX != des[0]) {
                    startX += deltaX;
                    time++;
            
                    count[startX][startY][time]++;
                }
                
                while(startY != des[1]) {
                    startY += deltaY;
                    time++;
                    
                    count[startX][startY][time]++;
                }
            }
        }
        
        for(int i = 1; i <= 100; i++){
            for(int j = 1; j <= 100; j++){
                for(int k = 0; k <= 20000; k++){
                    if(count[i][j][k] >= 2) answer++;  
                }
            }
        }
        
        return answer;
    }
    
    public int delta(int cur, int des){
        return des - cur < 0 ? -1 : 1;    
    }
}