import java.util.*;
class Solution {
    int answer;
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        bfs(k, 0, dungeons, new boolean[dungeons.length]);
        return answer;
    }
    
    void bfs(int k, int cnt, int[][] dungeons, boolean[] visited){
        if(k < 0) cnt--;
        else{
            for(int i = 0; i < dungeons.length; i++){
                if(!visited[i] && dungeons[i][0] <= k) {
                    visited[i] = true;
                    bfs(k - dungeons[i][1], cnt + 1, dungeons, visited);
                    visited[i] = false;
                }
            }    
        }
        
        answer = Math.max(answer, cnt);
    }
}