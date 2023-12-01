class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int cnt = 0;
        int cntZero = 0;
        
        while(!s.equals("1")){
            String removeZero = s.replace("0","");
            int zero = s.length() - removeZero.length();
            String next = Integer.toBinaryString(removeZero.length());
            
            s = next;
            cntZero += zero;
            cnt++;
        }
        
        answer[0] = cnt;
        answer[1] = cntZero;
        
        return answer;
    }
}