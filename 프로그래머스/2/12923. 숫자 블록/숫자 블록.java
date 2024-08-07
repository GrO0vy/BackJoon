class Solution {
    public int[] solution(long begin, long end) {
        int first = (int) begin;
        int last = (int) end;
        
        int[] answer = new int[last - first + 1];
        
        for(int i = first; i <= last; i++){
            if(i == 1) answer[0] = 0;
            else answer[i - first] = greatest(i);
        }
        
        return answer;
    }
    
    int greatest(int n){
        int max = 1;
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                if(n % i == 0 && i <= 10000000) {
                    max = Math.max(max, i);
                    if(n / i <= 10000000 && n / i != n)
                        max = Math.max(max, n / i);
                }    
            }
        }
        
        return max;
    }
}