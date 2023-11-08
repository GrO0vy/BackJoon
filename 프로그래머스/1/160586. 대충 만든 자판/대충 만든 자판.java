import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        HashMap<Character, Integer> keys = new HashMap<>();
        
        for(String key: keymap){
            for(int i = 0; i < key.length(); i++){
                char c = key.charAt(i);
                int idx = key.indexOf(c);
                if(!keys.containsKey(c) || idx < keys.get(c)) keys.put(c, idx + 1); 
            }
        }
        
        int idx = 0;
        for(String target: targets){
            for(int i = 0; i < target.length(); i++){
                char c = target.charAt(i);
                if(keys.containsKey(c)) answer[idx] += keys.get(c);
                else {
                    answer[idx] = -1;
                    break;
                }
            }
            idx++;
        }
        
        return answer;
    }
}