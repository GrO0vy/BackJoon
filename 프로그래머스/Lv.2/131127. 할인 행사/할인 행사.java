import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for(int i = 0; i < discount.length - 9; i++){
            HashMap<String, Integer> customer = new HashMap<>();
            for(int j = 0; j < want.length; j++){
                customer.put(want[j], number[j]);
            }
            
            for(int j = i; j < i + 10; j++){
                String article = discount[j % discount.length];
                if(!customer.containsKey(article)) continue;
                
                customer.put(article, customer.get(article) - 1);
            }
            
            boolean flag = true;
            for(int value: customer.values()){
                if(value > 0) {
                    flag = false;
                    break;
                }
            }
        
            if(flag) answer++;
        }
        
        return answer;
    }
}