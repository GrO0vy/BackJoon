class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left + 1)];
        
        for(int i = 0; i < answer.length; i++){
            int row = (int)(left / n);
            int col = (int)(left % n);
            
            if(col <= row) answer[i] = row + 1;
            else answer[i] = col + 1;
            
            left++;
        }
        
        return answer;
    }
}