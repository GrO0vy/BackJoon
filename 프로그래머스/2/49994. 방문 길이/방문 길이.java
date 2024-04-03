import java.util.HashSet;
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        HashSet<String> set = new HashSet<>();
        int x = 5;
        int y = 5;
        
        for(int i = 0; i < dirs.length(); i++){
            char dir = dirs.charAt(i);
            int curX = x;
            int curY = y;
            
            switch(dir){
                case 'U': x++; break;
                case 'D': x--; break;
                case 'R': y++; break;
                case 'L': y--; break;
            }
            
            int nextX = x;
            int nextY = y;
            
            if(inRange(nextX, nextY, 11)){
                set.add("" + curX + curY + nextX + nextY);
                set.add("" + nextX + nextY + curX + curY);  
            }
            else{
                x = curX;
                y = curY;
            }
        }
        
        answer = set.size() / 2;
        return answer;
    }
    
    boolean inRange(int x, int y, int len){
        return -1 < x && x < len && -1 < y && y < len;
    }
}