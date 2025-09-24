import java.util.*;
class Solution {
    public int solution(int[] a) {
        int answer = 0;
        
        Map<Integer, Integer> counter = new HashMap<>();
        for(int num: a){
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        
        for(int num: counter.keySet()){
            if(counter.get(num) < answer) continue;
            int length = 0;
            for(int i = 0; i < a.length - 1; i++){
                if(a[i] != a[i + 1] && (a[i] == num || a[i + 1] == num)){
                    length++;
                    i++;
                }
            }
            
            answer = Math.max(answer, length);
        }
        
        return answer * 2;
    }
}