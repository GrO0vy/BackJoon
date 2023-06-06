import java.util.List;
import java.util.ArrayList;
class Solution {
    public List<String> solution(String[] todo_list, boolean[] finished) {
        List<String> answer = new ArrayList<>();
        
        int idx = 0;
        for(int i=0; i<todo_list.length; i++){
            if(!finished[i]) answer.add(todo_list[i]);
        }
        return answer;
    }
}