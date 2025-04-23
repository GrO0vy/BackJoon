import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> cntCompletion = new HashMap<>();
        
        for(String name: completion){
            cntCompletion.put(name, cntCompletion.getOrDefault(name, 0) + 1);
        }
        
        for(String name: participant){
            if(cntCompletion.get(name) == null || cntCompletion.get(name) == 0){
                answer = name;
                break;
            }
            
            cntCompletion.put(name, cntCompletion.get(name) - 1);
        }
        
        return answer;
    }
}