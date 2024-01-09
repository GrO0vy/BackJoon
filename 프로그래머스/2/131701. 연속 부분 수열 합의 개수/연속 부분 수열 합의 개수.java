import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < elements.length; i++){
            int start = 0;
            do{
                int sum = 0;
                for(int j = start; j <= start + i; j++){
                    sum += elements[j % elements.length];        
                }
                set.add(sum);
                start = (start + 1) % elements.length;
            }while(start > 0);
        }
        
        answer = set.size();
        return answer;
    }
}