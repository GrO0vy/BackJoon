import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;
        
        int min = Integer.MAX_VALUE;
        int max = 0;
        
        for(int stone: stones) {
            min = Math.min(min, stone);
            max = Math.max(max, stone);
        }
        
        while(min <= max){
            int person = (min + max) / 2;
            
            int length = 0;
            
            for(int stone: stones){
                if(stone - person < 0) length++;
                else length = 0;
                
                if(length == k) break;
            }
            
            if(length >= k) max = person - 1;
            else{
                answer = person;
                min = person + 1;
            }
        }
        
        return answer;
    }
}