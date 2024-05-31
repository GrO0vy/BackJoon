import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        HashMap<String, Integer> score = new HashMap<>();
        score.put("diamond", 25);
        score.put("iron", 5);
        score.put("stone", 1);
        
        int possible = 0;
        for(int pick : picks) possible += pick;
        possible *= 5;
        
        List<int[]> piro = new ArrayList<>();
        for(int i = 0; i < minerals.length && i < possible; i+=5){
            int[] row = new int[2];
            for(int j = i; j < i + 5; j++){
                if(j >= minerals.length || j >= possible) break;
                row[0] += score.get(minerals[j]);
                row[1] = j - i + 1;
            }
            piro.add(row);
        }
        
        Collections.sort(piro, new Comparator<>(){
            public int compare(int[] o1, int[] o2){
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                else return o2[0] - o1[0]; 
            }
        });
        
        for(int i = 0; i < piro.size(); i++){
            int cur = piro.get(i)[0];
            
            int dia = cur / 25;
            if(cur % 25 == 0 && dia != piro.get(i)[1]){
                dia = 0;    
            }
            else cur %= 25;
            
            
            int iron = cur / 5;
            if(cur % 5 == 0 && dia + iron != piro.get(i)[1]){
                iron = 0;
            }
            else cur %= 5;
            
            int stone = cur;
            
            if(picks[0] > 0) {
                answer += dia + iron + stone;
                picks[0]--;
            }
            else if(picks[1] > 0){
                answer += dia * 5 + iron + stone;
                picks[1]--;
            }
            
            else{
                answer += dia * 25 + iron * 5 + stone;
                picks[2]--;
            }
        }
        
        return answer;
    }
}