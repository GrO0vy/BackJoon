import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        if(arr.length == 1) answer = new int[]{-1};
        else{
            List<Integer> list = new ArrayList<>();
            for(int num : arr) list.add(num);
            list.remove(list.indexOf(Collections.min(list)));
            answer = new int[list.size()];
            for(int i = 0; i < list.size(); i++){
                answer[i] = list.get(i);
            }
        }
        
        return answer;
    }
}