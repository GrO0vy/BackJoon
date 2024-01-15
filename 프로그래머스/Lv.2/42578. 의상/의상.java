import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] cloth: clothes){
            String category = cloth[1];
            map.put(category, map.getOrDefault(category, 0) + 1);
        }
        
        for(String key : map.keySet()) {
            answer *= (map.get(key) + 1);
        }
        
        answer -= 1; 
        
        return answer;
    }
}