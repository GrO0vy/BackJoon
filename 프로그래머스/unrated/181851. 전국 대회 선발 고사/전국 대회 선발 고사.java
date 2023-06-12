import java.util.*;
class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        
        Map<Integer,Integer> ranking = new HashMap<>();
        
        for(int i = 0; i < rank.length; i++){
            ranking.put(rank[i], i);
        }
        
        List<Integer> sortRank = new ArrayList<>();
        
        for(var key : ranking.keySet()){
            sortRank.add(key);
        }
        
        Collections.sort(sortRank);
        
        int count = 2;
        int idx = 0;
        while(count >= 0){
            int number = ranking.get(sortRank.get(idx++));
            if(attendance[number] == true){
                answer += number * (int)Math.pow(100,count--);
            }
        }
        
        return answer;
    }
}