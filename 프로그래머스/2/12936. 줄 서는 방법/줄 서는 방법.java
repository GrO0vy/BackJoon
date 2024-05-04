import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        
        List<Integer> people = new ArrayList<>();
        long factorial = 1;
        
        k--;
        for(int i = 1; i <= n; i++){
            factorial *= i;
            people.add(i);
        }
        
        int idx = 0;
        
        while(n > 0){
            factorial /= n;
            int value = (int) (k / factorial);
            
            answer[idx++] = people.get(value);
            people.remove(value);
            
            k %= factorial;
            n--;
        }
        
        return answer;
    }
}