import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int[] stk = {};
        int i = 0;
        
        List<Integer> result = new ArrayList<>();
        
        while(arr.length > i){
            if(result.size() == 0) {
                result.add(arr[i++]);
            }
            else{
                if(result.get(result.size()-1) < arr[i]) result.add(arr[i++]);
                else result.remove(result.size()-1);
            }
            
        }
        
        stk = new int[result.size()];
        for(int j = 0; j < result.size(); j++){
            stk[j] = result.get(j);
        }
        return stk;
    }
}