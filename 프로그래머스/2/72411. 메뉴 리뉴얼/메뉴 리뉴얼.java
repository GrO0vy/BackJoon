import java.util.*;

class Solution {
    HashMap<String, Integer> map;
    int max;
    public List<String> solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        map = new HashMap<>();
        
        for(int i = 0; i < orders.length; i++){
            char[] charArr = orders[i].toCharArray();
            Arrays.sort(charArr);
            orders[i] = String.valueOf(charArr);
        }
        
        for(int i = 0; i < course.length; i++){
            map = new HashMap<>();
            max = 0;
            
            for(int j = 0; j < orders.length; j++){
                combi(new StringBuilder(), orders[j], 0, course[i]);
            }
            
            for(String key: map.keySet()) 
                if(max > 1 && map.get(key) > 1 && max == map.get(key)) answer.add(key);
        }
        
        Collections.sort(answer);
        
        return answer;
    }
    
    void combi(StringBuilder sb, String order, int idx, int limit){
        if(sb.length() == limit){
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            max = Math.max(max, map.get(sb.toString()));
        } 
            
        else{
            for(int i = idx; i < order.length(); i++){
                sb.append(order.charAt(i));
                combi(sb, order, i + 1, limit);
                sb.deleteCharAt(sb.length() - 1);
            }    
        }
    }
}