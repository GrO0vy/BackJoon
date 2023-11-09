import java.util.HashMap;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int[][] keyMap = {{3,1}, {0,0}, {0,1}, {0,2}, {1,0}, {1,1}, 
                        {1,2}, {2,0}, {2,1}, {2,2}};
        
        HashMap<Integer, int[]> phone = new HashMap<>();
        
        for(int i = 0; i < 10; i++){
            phone.put(i, keyMap[i]);
        }
        
        int[] left = {3, 0};
        int[] right = {3, 2};
        
        StringBuilder sb = new StringBuilder();
        
        for(int num: numbers){
            int[] des = phone.get(num);
            if(num == 1 || num == 4 || num == 7){
                left = des;
                sb.append("L");
            }
            else if(num == 3 || num == 6 || num == 9){
                right = des;
                sb.append("R");
            }
            else{
                int lDis = Math.abs(left[0] - des[0]) + Math.abs(left[1] - des[1]);
                int rDis = Math.abs(right[0] - des[0]) + Math.abs(right[1] - des[1]);
                
                if(lDis == rDis) {
                    if(hand.equals("left")){
                        left = des;
                        sb.append("L");
                    }
                    else {
                        right = des;
                        sb.append("R");
                    }
                }
                else if(lDis < rDis){
                    left = des;
                    sb.append("L");
                }
                else{
                    right = des;
                    sb.append("R");
                }
            }
        }
        answer = sb.toString();
        return answer;
    }
}