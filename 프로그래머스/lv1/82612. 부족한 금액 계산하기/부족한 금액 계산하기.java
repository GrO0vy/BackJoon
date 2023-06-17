class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long totalPrice = 0;
        
        for(long i = 1; i <= count; i++){
            totalPrice += price * i;
        }
         
        answer = money >= totalPrice ? 0 : totalPrice - money;

        return answer;
    }
}