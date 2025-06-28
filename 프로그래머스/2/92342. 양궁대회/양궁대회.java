import java.util.*;

class Solution {
    int max = 0;
    int[] answer;
    int[] apeach;
    
    public int[] solution(int n, int[] info) {
        answer = new int[11];
        apeach = info;
        
        dfs(0, new int[11], n);
        
        return max > 0 ? answer : new int[]{-1};
    }
    
    void dfs(int index, int[] lion, int arrows){
        if(index == 11){
            lion[10] = arrows;
            
            int diff = calDiff(lion);
            
            if(diff > max){
                max = diff;
                answer = Arrays.copyOf(lion, lion.length);
            }
            else if(diff == max){
                for(int i = 10; i >= 0; i--){
                    if(lion[i] == answer[i]) continue;
                    
                    if(lion[i] > answer[i]) answer = Arrays.copyOf(lion, lion.length);
                    break;
                }
            }
        }
        else{
            if(arrows > apeach[index]){
                lion[index] = apeach[index] + 1;
                dfs(index + 1, lion, arrows - lion[index]);
                lion[index] = 0;    
            }
            
            dfs(index + 1, lion, arrows);
        }
    }
    
    int calDiff(int[] lion){
        int diff = 0;
        
        for(int i = 0; i <= 10; i++){
            if(lion[i] == 0 && apeach[i] == 0) continue;
            
            if(lion[i] > apeach[i]) diff += 10 - i;
            else diff -= 10 - i;
        }
        
        return diff;
    }
}