import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        
        HashMap<String, String> users = new HashMap<>();
        List<String[]> logs = new ArrayList<>();
        
        for(String r: record){
            String[] log = r.split(" ");
            
            if(log[0].equals("Enter") || log[0].equals("Change")) 
                users.put(log[1], log[2]);
            
            if(!log[0].equals("Change"))
                logs.add(new String[]{log[0], log[1]});
        }
        
        answer = new String[logs.size()];
        for(int i = 0; i < logs.size(); i++){
            String message = "";
            String[] log = logs.get(i);
            
            if(log[0].equals("Enter")) 
                message = String.format("%s님이 들어왔습니다.", users.get(log[1]));
            else 
                message = String.format("%s님이 나갔습니다.", users.get(log[1]));
            
            answer[i] = message;
        }
        
        return answer;
    }
}