class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int[] sum = new int[n / 2 + 2];
        for(int i = 1; i < sum.length; i++){
            sum[i] = sum[i - 1] + i;
        }
        
        int start = 0;
        int end = 1;
        
        while(end < sum.length){
            if(sum[end] - sum[start] < n) end++;
            else if(sum[end] - sum[start] > n) start++;
            else{
                answer++;
                start++;
                end++;
            }
        }
        
        return n == 1 || n == 2 ? answer : answer + 1;
    }
}