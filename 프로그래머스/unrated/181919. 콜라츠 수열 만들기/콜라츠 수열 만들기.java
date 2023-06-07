import java.util.List;
import java.util.ArrayList;
class Solution {
    public List<Integer> solution(int n) {
        
        List<Integer> result = new ArrayList<>();
        
        result.add(n);
        while(n != 1){
            if(n % 2 == 0) n /= 2;
            else n = n * 3  + 1;
            result.add(n);
        }
        
        return result;
    }
}