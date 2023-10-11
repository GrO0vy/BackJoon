import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer;
        List<Integer> result = new ArrayList<>();
        
        String[] Todaydate = today.split("\\.");
        
        int todayToDay = Integer.parseInt(Todaydate[0]) * 336 
            + (Integer.parseInt(Todaydate[1]) - 1) * 28 + Integer.parseInt(Todaydate[2]);
        
        for(int i = 0; i < privacies.length; i++){
            String startDate = privacies[i].split(" ")[0];
            String term = privacies[i].split(" ")[1];
            
            String[] date = startDate.split("\\.");
            
            int totalDate = Integer.parseInt(date[0]) * 336 +
                (Integer.parseInt(date[1]) - 1) * 28 + Integer.parseInt(date[2]);
            
            for(String trm: terms){
                if(trm.contains(term)){
                    int month = Integer.parseInt(trm.split(" ")[1]);
                    totalDate += (month * 28 - 1);
                }
            }
            
            if(todayToDay > totalDate) result.add(i + 1);
        }
        
        answer = new int[result.size()];
        
        for(int i = 0; i < answer.length; i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}