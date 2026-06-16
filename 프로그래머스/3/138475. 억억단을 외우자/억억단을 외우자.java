import java.util.*;

class Solution {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        
        int[] cntNum = new int[e + 1];
        Integer[] maxNum = new Integer[e + 1];
        maxNum[0] = 0;
        
        for(int i = 1; i <= e; i++) {
            for(int j = i; j <= e; j += i){
                cntNum[j]++;
            }
            
            maxNum[i] = i;
        }
        
        Arrays.sort(maxNum, (o1, o2) -> cntNum[o2] - cntNum[o1]);
        
        int[] startsFrom = new int[e + 1];
        
        int idx = 1;
        for(int maxFreqNum: maxNum){
            for(; idx <= maxFreqNum; idx++){
                startsFrom[idx] = maxFreqNum;
            }
        }
        
        for(int i = 0; i < starts.length; i++){
            int start = starts[i];
            
            answer[i] = startsFrom[start];    
        }
        
        return answer;
    }
    
    private int getCntFactor(int num){
        int cnt = 0;
        
        for(int i = 1; i * i <= num; i++){
            if(num % i == 0){
                if(i * i == num) cnt++;
                else cnt += 2;    
            }
        }
        
        return cnt;
    }
}