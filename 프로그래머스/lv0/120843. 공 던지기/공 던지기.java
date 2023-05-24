class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        int count = 0;
        int idx = 0;
        
        while(count < k-1){
            if(idx + 2 > numbers.length -1) idx = 1 - (numbers.length-1-idx);
            else idx += 2;
            count++;
        }
        answer = numbers[idx];
        return answer;
    }
}