class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        
        int width = board[0] / 2;
        int height = board[1] / 2;
        for(String key : keyinput){
            switch(key){
                case "left" :
                    if(-width < answer[0]) answer[0] -= 1;
                    break;
                case "right" :
                    if(width > answer[0]) answer[0] += 1;
                    break;
                case "up" :
                    if(height > answer[1]) answer[1] += 1;
                    break;
                case "down" :
                    if(-height < answer[1]) answer[1] -= 1;
                    break;
            }
        }
        
        return answer;
    }
}