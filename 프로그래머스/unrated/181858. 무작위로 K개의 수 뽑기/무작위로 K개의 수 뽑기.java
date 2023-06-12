import java.util.*;
class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = {};
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++){
            if(result.size() >= k) break;
            if(!result.contains(arr[i])) result.add(arr[i]);
        }
        
        answer = new int[k];
        Arrays.fill(answer,-1);
        
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}