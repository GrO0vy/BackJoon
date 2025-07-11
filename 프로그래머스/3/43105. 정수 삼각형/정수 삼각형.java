import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int[][] sum = new int[triangle.length][triangle[triangle.length - 1].length];
        sum[0][0] = triangle[0][0];
        
        for(int i = 1; i < triangle.length; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0){
                    sum[i][j] = sum[i - 1][j] + triangle[i][j];    
                }
                else if(j == i){
                    sum[i][j] = sum[i - 1][j - 1] + triangle[i][j];
                }
                else{
                    sum[i][j] = Math.max(sum[i][j], sum[i - 1][j - 1] + triangle[i][j]);
                    sum[i][j] = Math.max(sum[i][j], sum[i - 1][j] + triangle[i][j]);
                }
                
                answer = Math.max(answer, sum[i][j]);
            }    
        }
        
        return answer;
    }
}