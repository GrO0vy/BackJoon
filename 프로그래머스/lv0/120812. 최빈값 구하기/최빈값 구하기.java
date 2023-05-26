import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<array.length; i++){
            list.add(array[i]);
        }
        
        Map<Integer,Integer> result = new HashMap<>();
    
        int maxCount =0;
        int freqNum =0;
        
        while(list.size() > 0){
            int count = Collections.frequency(list,list.get(0));
            if(count > maxCount) maxCount = count;
            result.put(list.get(0),count);
            list.removeAll(Arrays.asList(list.get(0)));
        }
        
        int freqCnt = 0;
        for(int key : result.keySet() ){
            int value = result.get(key);
            if(maxCount == value) {
                freqNum = key;
                freqCnt++;
            }
            if(freqCnt > 1) return -1;
        }
        
        return freqNum;
    }
}