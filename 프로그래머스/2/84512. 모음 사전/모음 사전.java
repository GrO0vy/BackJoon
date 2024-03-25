import java.util.*;

class Solution {
    String[] alphas = {"A", "E", "I", "O", "U"};
    List<String> list = new ArrayList<>();
    int answer;
    
    public int solution(String word){
        dfs("");
        
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals(word)){
                answer = i;
                break;
            }
        }
        return answer;
    }
    
    public void dfs(String str){
        if(str.length() > 5) return;
        
        list.add(str);
        for(String alpha: alphas){
            dfs(str + alpha);
        }
    }
}