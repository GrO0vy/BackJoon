class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        
        for(int num = i; num <= j; num++){
            int num2 = num;
            for(;num2 > 0;){
                if(num2 % 10 == k) {
                    answer++;
                }
                num2 /= 10;
            }
        }
        return answer;
    }
}