import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {1, gems.length};
        
        Set<String> types = new HashSet<>();
        for(String gem: gems) types.add(gem);
        
        Map<String, Integer> count = new HashMap<>();
        Set<String> set = new HashSet<>();
        
        int left = 0;
        
        for(int i = 0; i < gems.length; i++){
            String gem = gems[i];
            
            count.put(gem, count.getOrDefault(gem, 0) + 1);
            set.add(gem);
            
            while(set.size() == types.size()){
                if(answer[1] - answer[0] > i - left){
                    answer[0] = left + 1;
                    answer[1] = i + 1;    
                }
                
                count.put(gems[left], count.get(gems[left]) - 1);
                if(count.get(gems[left]) == 0) set.remove(gems[left]);
                left++;
            }
        }
        
        return answer;
    }
}