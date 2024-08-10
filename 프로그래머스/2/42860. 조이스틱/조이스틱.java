import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        
        char[] target = name.toCharArray();
        
        int alpha = 0;
        int cursor = target.length - 1;
        
        for(int i = 0; i < target.length; i++){
            alpha += Math.min(target[i] - 'A', ('Z' - target[i]) + 1);
            
            int next = i + 1;
            while(next < target.length && target[next] == 'A'){
                next++;
            }
            
            cursor = Math.min(cursor, (i * 2) + (target.length - next));
            cursor = Math.min(cursor, i + (target.length - next) * 2);
        }

        answer = cursor + alpha;
        return answer;
    }
}