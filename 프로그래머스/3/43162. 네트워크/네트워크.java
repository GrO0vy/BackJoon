import java.util.*;

class Solution {
    boolean[] visited;
    int[][] computers;
    int n;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        this.n = n;
        visited = new boolean[n];
        this.computers = computers;
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                searchNetwork(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    private void searchNetwork(int node){
        visited[node] = true;
        
        for(int i = 0; i < n; i++){
            if(computers[node][i] == 1 && !visited[i]) searchNetwork(i);
        }    
    }
}