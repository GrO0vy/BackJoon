class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int[] price = new int[]{6,6,5,4,3,2,1};
        
        int cntOfZero = 0;
        int result = 0;
        
        for(int i = 0; i < lottos.length; i++){
            if(lottos[i] == 0){
                cntOfZero++;
                continue;
            }
            for(int j = 0; j < win_nums.length; j++){
                if(lottos[i] == win_nums[j]){
                    result++;
                    break;
                }
            }
        }
        
        answer[0] = price[result + cntOfZero];
        answer[1] = price[result];
        
        return answer;
    }
}