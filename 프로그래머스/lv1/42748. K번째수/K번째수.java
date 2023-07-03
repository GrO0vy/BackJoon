import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> result = new ArrayList<>();
        int[] answer ={};
        
        for(int i = 0; i < commands.length; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j = commands[i][0] - 1; j <= commands[i][1] - 1; j++){
                temp.add(array[j]);
            }
            Collections.sort(temp);
            result.add(temp.get(commands[i][2] - 1));
        }
        
        answer = new int[result.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}