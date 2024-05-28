import java.util.*;

class Solution {
    private List<int[]> list = new ArrayList<>();
    public int[][] solution(int n) {
        int[][] answer = {};
        
        hanoi(n, 1, 3, 2);
        
        answer = new int[list.size()][2];
        
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);    
        }
        
        return answer;
    }
    
    private void hanoi(int n, int from, int to, int temp){
        if(n == 0) return;
        
        hanoi(n - 1, from, temp, to);
        list.add(new int[]{from, to});
        hanoi(n - 1, temp, to, from);
    }
}