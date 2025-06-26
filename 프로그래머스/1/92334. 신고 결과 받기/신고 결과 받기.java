import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        HashMap<String, Integer> idx = new HashMap<>();
        for(int i = 0; i < id_list.length; i++) idx.put(id_list[i], i);
        
        HashMap<String, Set<String>> reports = new HashMap<>();
        for(String log: report){
            String[] info = log.split(" ");
            
            if(!reports.containsKey(info[1])) reports.put(info[1], new HashSet<>());
            
            reports.get(info[1]).add(info[0]);
        }
        
        for(Map.Entry<String, Set<String>> entry: reports.entrySet()){
            if(entry.getValue().size() >= k){
                for(String user: entry.getValue()){
                    answer[idx.get(user)]++;
                }
            }
        }
        
        return answer;
    }
}