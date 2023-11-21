import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < players.length; i++){
            map.put(players[i], i);
        }
        
        for(String player: callings){
            int idx = map.get(player);
            
            players[idx] = players[idx - 1];
            players[idx - 1] = player;
            map.put(player, idx - 1);
            map.put(players[idx], idx);
        }
        
        for(int i = 0; i < players.length; i++){
            answer[i] = players[i];
        }
        return answer;
    }
}