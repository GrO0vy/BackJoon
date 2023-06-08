import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public String solution(String my_string, int[] indices) {
        String answer = "";
        
        for(int i=0; i<my_string.length(); i++){
            if(isContains(i, indices)) continue;
            answer += my_string.charAt(i);
        }
        return answer;
    }
    
    public boolean isContains(int idx, int[] indices){
        for(int i=0; i<indices.length; i++){
            if(indices[i] == idx) return true;   
        }
        return false;
    }
}