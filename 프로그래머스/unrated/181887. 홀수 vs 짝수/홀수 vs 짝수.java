class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int oddResult =0;
        int evenResult =0;
        
        for(int i=0; i<num_list.length; i++){
            if((i+1) % 2 == 0) evenResult += num_list[i];
            else oddResult += num_list[i];
        }
        
        answer = oddResult >= evenResult ? oddResult : evenResult;
        return answer;
    }
}