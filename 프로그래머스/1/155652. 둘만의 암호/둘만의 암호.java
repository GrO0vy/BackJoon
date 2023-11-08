import java.util.List;
import java.util.ArrayList;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        List<Character> alpha = new ArrayList<>();
        for(char c = 'a'; c <= 'z'; c++){
            alpha.add(c);
        }
        
        for(Character c : skip.toCharArray()){
            alpha.remove(c);
        }
        
        for(Character c: s.toCharArray()){
            int idx = alpha.indexOf(c);
            
            int change = (idx + index) % alpha.size();
            answer += alpha.get(change);
        }
        
        return answer;
    }
}