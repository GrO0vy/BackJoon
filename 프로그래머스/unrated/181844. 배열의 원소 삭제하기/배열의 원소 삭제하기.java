import java.util.List;
import java.util.ArrayList;
class Solution {
    public List<Integer> solution(int[] arr, int[] delete_list) {
        List<Integer> answer = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++){
            boolean isContains = false;
            for(int j=0; j<delete_list.length; j++){
                if(arr[i] == delete_list[j]){
                    isContains = true;
                    break;
                }
            }
            if(!isContains) answer.add(arr[i]);
        }
        return answer;
    }
}