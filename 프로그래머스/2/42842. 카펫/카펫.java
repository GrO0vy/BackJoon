import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int i = 1; i <= brown / 2; i++){
            if(yellow % i == 0 && (i + yellow / i) * 2  == brown - 4 ){
                answer[0] = i + 2;
                answer[1] = yellow / i + 2;
            }
        }
        
        if(answer[0] < answer[1]){
            int temp = answer[0];
            answer[0] = answer[1];
            answer[1] = temp;
        }
        
        return answer;
    }
}
