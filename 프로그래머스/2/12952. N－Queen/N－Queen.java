import java.util.*;

class Solution {
    int[][] map;
    int len;
    int[] row;
    int answer;
    
    public int solution(int n) {
        map = new int[n][n];
        row = new int[n];
        Arrays.fill(row, - 1);
        len = n;
        
        recur(0);
        
        return answer;
    }
    
    void recur(int r){
        if(r == len){
            answer++;
            return;
        }
        for(int i = 0; i < len; i++){
            if(check(r, i)) {
                map[r][i] = 1;
                row[r] = i;
                recur(r + 1);
            }
            
            map[r][i] = 0;
            row[r] = -1;
        }    
    }
    
    boolean check(int r, int c){
        for(int i = 0; i < r; i++){
            if(row[i] == c || Math.abs(r - i) == Math.abs(row[i] - c))
                return false;
        }
        
        return true;
    }
}