import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int one = correct(new int[]{1,2,3,4,5},answers);
        int two = correct(new int[]{2,1,2,3,2,4,2,5},answers);
        int three = correct(new int[]{3,3,1,1,2,2,4,4,5,5},answers);
        
        List<Integer> result = new ArrayList<>();
        result.add(one);
        result.add(two);
        result.add(three);
        
        int max = Collections.max(result);
        
        answer = new int[Collections.frequency(result,max)];
        
        int idx = 0;
        
        for(int i = 0; i < result.size(); i++){
            if(result.get(i) == max) answer[idx++] = i+1;
        }
        
        return answer;
    }
    
    public int correct(int[] numbers, int[] answer){
        int result = 0;
        
        int idx = 0;
        
        for(int i = 0; i < answer.length; i++){
            if(idx > numbers.length - 1) idx = 0;
            if(numbers[idx] == answer[i]) result++;
            idx++;
        }
        
        return result;
    }
}