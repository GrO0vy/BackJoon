import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);
        
        
        for(int i = 0; i < survey.length; i++){
            int choice = choices[i];
            if(choice == 4) continue;
            
            String s = survey[i];
            
            if(choice < 4){
                char key = s.charAt(0);
                map.put(key, map.get(key) + 4 - choice);
            }
            else{
                char key = s.charAt(1);
                map.put(key, map.get(key) + choice - 4);
            }
        }
        
        if(map.get('R') >= map.get('T')) answer += 'R';
        else answer += 'T';
        
        if(map.get('C') >= map.get('F')) answer += 'C';
        else answer += 'F';
        
        if(map.get('J') >= map.get('M')) answer += 'J';
        else answer += 'M';
        
        if(map.get('A') >= map.get('N')) answer += 'A';
        else answer += 'N';
        
        return answer;
    }
}