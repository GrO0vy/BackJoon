import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        List<Integer> hallOfFame = new ArrayList<>();
        int[] answer = new int[score.length];
        
        for(int i = 0; i < k; i++){
            if(score.length <= i) break;
            hallOfFame.add(score[i]);
            answer[i] = Collections.min(hallOfFame);
        }
        
        for(int i = k; i < score.length; i++){
            int min = Collections.min(hallOfFame);
            if(score[i] > min){
                hallOfFame.remove(hallOfFame.indexOf(min));
                hallOfFame.add(score[i]);
            }
            
            answer[i] = Collections.min(hallOfFame);
        }
        
        return answer;
    }
}