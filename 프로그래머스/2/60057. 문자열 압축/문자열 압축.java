import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        
        for(int i = 1; i <= s.length(); i++){
            String tar = "";
            
            for(int j = 0; j < s.length(); j += i){
                String str;
                
                if(j + i >= s.length()) str = s.substring(j);
                else str = s.substring(j, j + i);
                
                int cnt = 0;
                while(j < s.length() && j + i <= s.length() 
                      && str.equals(s.substring(j, j + i)))
                {
                    cnt++;
                    j += i;
                }
                
                if(cnt <= 1) tar += str;
                else tar += cnt + str;
                
                if(cnt > 0) j -= i;
            }
            
            answer = Math.min(answer, tar.length());
        }
        return answer;
    }
}