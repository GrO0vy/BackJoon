import java.util.*;

class Solution {
    int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public List<Integer> solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length(); j++){
                if(!visited[i][j] && maps[i].charAt(j) != 'X') 
                    answer.add(bfs(i, j, maps, visited));
            }
        }
        
        Collections.sort(answer);
        if(answer.isEmpty()) answer.add(-1);
        
        return answer;
    }
    
    int bfs(int x, int y, String[] maps, boolean[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        
        int area = 0;
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int curX = pos[0];
            int curY = pos[1];
            
            if(visited[curX][curY]) continue;
            
            visited[curX][curY] = true;
            area += maps[curX].charAt(curY) - '0';
            
            for(int[] delta: deltas){
                int nextX = curX + delta[0];
                int nextY = curY + delta[1];
                
                if(inRange(nextX, nextY, maps.length, maps[0].length()) && !visited[nextX][nextY] && maps[nextX].charAt(nextY) != 'X') queue.add(new int[]{nextX, nextY});
            }
        }
        
        return area;
    }
    
    boolean inRange(int x, int y, int maxX, int maxY){
        return -1 < x && x < maxX && -1 < y && y < maxY;
    }
}