import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] letters = s.toCharArray();
        
        int idx = 0;
        while(idx < letters.length){
            char start = letters[idx++];
            int startCount = 1;
            int othersCount = 0;
            
            while(idx < letters.length && startCount != othersCount){
                if(letters[idx] == start) startCount++;
                else othersCount++;
                idx++;
            }
            
            answer++;
        }
      
        return answer;
    }
}