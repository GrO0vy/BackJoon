import java.util.*;
class Solution {
    public long solution(long n) {
        String[] digits = (n+"").split("");
        Arrays.sort(digits);
        
        StringBuilder sb = new StringBuilder();
        for(var digit : digits) sb.append(digit);
        
        
        return Long.parseLong(sb.reverse().toString());
    }
}