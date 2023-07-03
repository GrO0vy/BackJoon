import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < numbers.length; i ++){
            for(int j = 0; j < numbers.length; j++){
                int sum = numbers[i] + numbers[j];
                if(i == j || result.contains(sum)) continue;
                result.add(sum);
            }
        }
        
        answer = new int[result.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = result.get(i);
        }
        
        Arrays.sort(answer);
        return answer;
    }
}