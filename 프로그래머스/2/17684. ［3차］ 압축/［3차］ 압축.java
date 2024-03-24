import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        List<String> dict = new ArrayList<>();
        for(char i = 'A'; i <= 'Z'; i++) dict.add(i + "");
        
        while(msg.length() > 0){
            String remove = "";
            int idx = 0;
            for(int i = 0; i < dict.size(); i++){
                String str = dict.get(i);
                if(msg.startsWith(str) && remove.length() < str.length()){
                    remove = str;
                    idx = i + 1;
                } 
            }
            
            answer.add(idx);
            msg = msg.replaceFirst(remove, "");
            if(msg.length() > 0) dict.add(remove + "" + msg.charAt(0));
            else dict.add(remove);
        }
        
        return answer;
    }
}