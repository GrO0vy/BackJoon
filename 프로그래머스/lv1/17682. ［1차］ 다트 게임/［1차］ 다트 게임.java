import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        String score = dartResult.replaceAll("\\*|#","");
        String bonus = dartResult.replaceAll("[^A-Z]","");
        String[] scores = score.split("[A-Z]");
        int[] result = new int[scores.length];
        
        for(int i = 0; i < bonus.length(); i++){
            int num = Integer.parseInt(scores[i]);
            switch(bonus.charAt(i)){
                case 'D': 
                    num = (int)Math.pow(num,2);
                    break;
                case 'T':
                    num = (int)Math.pow(num,3);
                    break;
            }
            result[i] = num;
        }
        
        if(dartResult.length() > score.length()){
            String str = dartResult.replaceAll("[A-Z]","");
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) == '#'){
                    result[i-1] *= -1;
                    str = str.replaceFirst("#","");
                }
                else if(str.charAt(i) == '*'){
                    result[i-1] *= 2;
                    if(i-1 > 0) result[i-2] *= 2;
                    str = str.replaceFirst("\\*","");
                }
            }
        }
        
        for(int i = 0; i < 3; i++){
            answer += result[i];
        }
        return answer;
    }
}