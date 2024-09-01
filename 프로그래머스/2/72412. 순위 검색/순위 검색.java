import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        HashMap<String, List<Integer>> map = new HashMap<>();
        
        for(String s : info){
            String[][] data = new String[2][5];
            data[0] = s.split(" ");
            Arrays.fill(data[1], "-");
            int score = Integer.parseInt(data[0][4]);
            
            for(int i = 0; i < 2; i++){
                for(int j = 0; j < 2; j++){
                    for(int k = 0; k < 2; k++){
                        for(int l = 0; l < 2; l++){
                            String key = data[i][0] + data[j][1] + data[k][2] + data[l][3];
                        
                            if(!map.containsKey(key)) map.put(key, new ArrayList<>()); 
                        
                            map.get(key).add(score);    
                        }
                        
                    }
                }
            }
        }
        
        for(String key : map.keySet()){
            Collections.sort(map.get(key));
        }
        
        int idx = 0;
        for(String q : query){
            int divide = q.lastIndexOf(" ");
            
            String condition = q.substring(0, divide);
            condition = condition.replace("and", "").replace(" ", "");
            
            int score = Integer.parseInt(q.substring(divide + 1));
    
            if(!map.containsKey(condition)) {
                idx++;
                continue;
            }
            
            List<Integer> list = map.get(condition);
            
            int left = 0;
            int right = list.size() - 1;
            
            while(left <= right){
                int mid = (left + right) / 2;
                
                if(list.get(mid) < score){
                    left = mid + 1;
                }
                else right = mid - 1;
            }
            
            answer[idx++] = list.size() - left;
        }
        
        return answer;
    }
}