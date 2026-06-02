import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        
        int reqAlp = 0;
        int reqCop = 0;
        
        int[][] study = {{1, 0, 1}, {0, 1, 1}};
        
        for(int[] problem: problems){
            reqAlp = Math.max(reqAlp, problem[0]);
            reqCop = Math.max(reqCop, problem[1]);
        }
        
        int[][] costs = new int[reqAlp + 1][reqCop + 1];
        for(int[] row: costs) Arrays.fill(row, Integer.MAX_VALUE);
        
        alp = Math.min(reqAlp, alp);
        cop = Math.min(reqCop, cop);
        
        costs[alp][cop] = 0;
        
        for(int i = alp; i <= reqAlp; i++){
            for(int j = cop; j <= reqCop; j++){
                for(int[] s: study){
                    int nextAlp = Math.min(reqAlp, i + s[0]);
                    int nextCop = Math.min(reqCop, j + s[1]);
                    int nextCost = costs[i][j] + 1;
                    
                    costs[nextAlp][nextCop] = Math.min(costs[nextAlp][nextCop], nextCost);
                }
                
                for(int[] problem: problems){
                    if(i < problem[0] || j < problem[1]) continue;
                    
                    int nextAlp = Math.min(reqAlp, i + problem[2]);
                    int nextCop = Math.min(reqCop, j + problem[3]);
                    int nextCost = costs[i][j] + problem[4];
                    
                    costs[nextAlp][nextCop] = Math.min(costs[nextAlp][nextCop], nextCost);   
                }
            }
        }
        
        answer = costs[reqAlp][reqCop];
        
        return answer;
    }
}