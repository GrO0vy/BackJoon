class Solution {
    public int solution(int[] array, int n) {
        int answer=0;
        int near = 100;
        for(int num : array){
            int diff = num - n;
            if(diff < 0) diff = -diff;
            if(diff < near || (diff == near && num < answer)) {
                near = diff;
                answer = num;
            }
        }
        return answer;
    }
}