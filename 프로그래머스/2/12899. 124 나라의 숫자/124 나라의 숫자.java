import java.util.*;

class Solution {
    public String solution(int n) {
        String answer = "";
        List<Integer> threeNum = toThreeBase(n);
        
        StringBuilder sb = new StringBuilder();
        for(int digit: threeNum) sb.append((int)Math.pow(2, digit));
        
        answer = sb.reverse().toString();
        return answer;
    }
    
    List<Integer> toThreeBase(int n){
        List<Integer> threeNum = new ArrayList<>();
        
        while(n > 3){
            threeNum.add((n % 3 + 2) % 3);
            n = (n - 1) / 3;
        }
        
        threeNum.add((n % 3 + 2) % 3);
        return threeNum;
    }
}