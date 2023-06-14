class Solution {
    boolean solution(String s) {
        boolean answer = false;
        s = s.toLowerCase();
        int cntX = 0;
        int cntY = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'p') cntX++;
            if(s.charAt(i) == 'y') cntY++;
        }
        
        if(cntX == cntY) answer = true;

        return answer;
    }
}