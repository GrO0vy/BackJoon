import java.util.*;

class Solution {
    Set<Set<String>> result;
    List<List<String>> list;
    
    public int solution(String[] user_id, String[] banned_id) {
        result = new HashSet<>();
        
        list = new ArrayList<>();
        for(int i = 0; i < banned_id.length; i++) list.add(new ArrayList<>());
        
        for(int i = 0; i < banned_id.length; i++){
            String regex = banned_id[i].replace("*", ".");
            
            for(int j = 0; j < user_id.length; j++){
                if(user_id[j].matches(regex)) list.get(i).add(user_id[j]);
            }
        }
        
        dfs(0, new ArrayList<>());
        
        return result.size();
    }
    
    void dfs(int idx, List<String> l){
        if(idx == list.size()){
            Set<String> set = new HashSet<>(l);
            
            if(set.size() == list.size()) result.add(set);
        
            return;
        }
        
        for(String id: list.get(idx)){
            l.add(id);
            dfs(idx + 1, l);
            l.remove(id);
        }
    }
}