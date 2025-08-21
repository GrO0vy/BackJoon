import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = -1;
        
        int[] target = scores[0];

        Arrays.sort(scores, new Comparator<>(){
            public int compare(int[] o1, int[] o2){
                if(o1[0] != o2[0]) return o2[0] - o1[0];
                
                return o1[1] - o2[1];
            }
        });
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0] + o2[1] - (o1[0] + o1[1]));
        
        int idx = 0;
        int[] prev = scores[0];
        while(idx < scores.length && prev[0] == scores[idx][0]){
            pq.offer(scores[idx]);
            prev = scores[idx];
            idx++;    
        } 
        
        while(idx < scores.length){
            if(scores[idx][1] >= prev[1]){
                pq.offer(scores[idx]);
                prev = scores[idx];
            }
            
            idx++;
        }
        
        int cnt = pq.size();
        int rank = 1;
        int prevScore = 0;
        
        
        for(int i = 1; i <= cnt; i++){
            int[] current = pq.poll();
            
            if(current[0] + current[1] != prevScore){
                prevScore = current[0] + current[1];
                rank = i;
            }
            
            if(current[0] == target[0] && current[1] == target[1]){
                answer = rank;
                break;
            }
        }
        
        return answer;
    }
}