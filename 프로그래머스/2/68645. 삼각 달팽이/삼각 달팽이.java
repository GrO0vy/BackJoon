class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        int len = n;
        
        int max = 1;
        for(int i = 2; i <= n; i++){
            max = i + max;    
        }
        
        int[] answer = new int[max];
        
        int num = 1;
        
        int x = -1;
        int y = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(i % 3 == 0) x++;
                else if(i % 3 == 1) y++;
                else{
                    x--;
                    y--;
                }
                arr[x][y] = num++;
            }
        }
        
        int idx = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                answer[idx++] = arr[i][j];
            }
        }
        
        return answer;
    }
}