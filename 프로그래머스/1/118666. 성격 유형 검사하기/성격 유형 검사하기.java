import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        char[][] types = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
        String answer = "";
        
        HashMap<Character, Integer> points = new HashMap<>();
        for(char[] type: types){
            points.put(type[0], 0);
            points.put(type[1], 0);
        }
        
        
        for(int i = 0; i < survey.length; i++){
            int choice = choices[i];
            if(choice == 4) continue;
            
            String s = survey[i];
            
            if(choice < 4){
                char key = s.charAt(0);
                points.put(key, points.get(key) + 4 - choice);
            }
            else{
                char key = s.charAt(1);
                points.put(key, points.get(key) + choice - 4);
            }
        }
        
        for(char[] type: types){
            if(points.get(type[0]) >= points.get(type[1])) answer += type[0];
            else answer += type[1];
        }
        
        return answer;
    }
}