import java.util.*;

class Solution {
    public int solution(int[][] beginning, int[][] target) {
        int answer;
        
        boolean[][] isMatched = new boolean[beginning.length][beginning[0].length];
        
        for(int i = 0; i < beginning.length; i++){
            for(int j = 0; j < beginning[0].length; j++){
                if(beginning[i][j] == target[i][j]) isMatched[i][j] = true;
            }
        }
        
        boolean[][] isMatched2 = new boolean[isMatched.length][isMatched[0].length];
        
        for(int i = 0; i < isMatched2.length; i++){
            isMatched2[i] = Arrays.copyOf(isMatched[i], isMatched[i].length);
        }
        
        for(int i = 0; i < isMatched2.length; i++){
            isMatched2[i][0] = !isMatched2[i][0];
        }
        
        answer = Math.min(getMinCnt(isMatched, 0), getMinCnt(isMatched2, 1));
        
        return answer;
    }
    
    int getMinCnt(boolean[][] isMatched, int result){
        int cnt = 0;
        
        for(int i = 0; i < isMatched.length; i++){
            if(!isMatched[i][0]) cnt++;
        }
        
        if(cnt == isMatched.length) result++;
        else result += cnt;
        
        
        if(0 < cnt && cnt < isMatched.length){
            for(int i = 0; i < isMatched.length; i++){
                if(!isMatched[i][0]) {
                    for(int j = 0; j < isMatched[i].length; j++){
                        isMatched[i][j] = !isMatched[i][j];
                    }
                }
            }    
        }
        
        
        
        for(int i = 1; i < isMatched[0].length; i++){
            cnt = 0;
            
            for(int j = 0; j < isMatched.length; j++){
                if(!isMatched[j][i]) {
                    isMatched[j][i] = true;
                    cnt++;
                }
            }
            
            if(cnt == isMatched.length) {
                result++;
            }
            else if(cnt > 0) return -1;
        }
        
        return result;
    }
}