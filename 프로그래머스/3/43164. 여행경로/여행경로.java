import java.util.*;

class Solution {
    static final String START = "ICN";
    String[] answer;
    
    public String[] solution(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        
        for(String[] ticket: tickets){
            String departure = ticket[0];
            String arrival = ticket[1];
            
            if(!map.containsKey(departure)) map.put(departure, new PriorityQueue<>());
            
            map.get(departure).offer(arrival);
        }
        
        answer = new String[tickets.length + 1];
        
        List<String> result = dfs(map, START, new ArrayList<>());
        
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    List<String> dfs(Map<String, PriorityQueue<String>> map, String departure, List<String> itinerary){
        while(map.containsKey(departure) && !map.get(departure).isEmpty()){
            dfs(map, map.get(departure).poll(), itinerary);
        }
        
        itinerary.add(0, departure);
        
        return itinerary;
    }
}