import java.util.*;

class Solution {
    int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int row;
    int col;
    
    public int solution(String[] maps) {
        int answer = 0;
        row = maps.length;
        col = maps[0].length();
        
        answer = bfs(maps);
        
        return answer;
    }
    
    int bfs(String[] maps){
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        int[] lever = findLever(maps);
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(findStart(maps));
        
        int result = -1;
        
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int curX = pos[0];
            int curY = pos[1];
            int cnt = pos[2];
            
            if(visited[curX][curY]) continue;
            visited[curX][curY] = true;
            
            if(visited[lever[0]][lever[1]] && maps[curX].charAt(curY) == 'E'){
                result = cnt;
                break;
            } 
            
            if(maps[curX].charAt(curY) == 'L'){
                for(int i = 0; i < visited.length; i++) Arrays.fill(visited[i], false);
                visited[curX][curY] = true;
                while(!queue.isEmpty()) queue.poll();
            }
            
            for(int[] delta : deltas){
                int nextX = curX + delta[0];
                int nextY = curY + delta[1];
                
                if(inRange(nextX, nextY) && !visited[nextX][nextY] && maps[nextX].charAt(nextY) != 'X') queue.offer(new int[]{nextX, nextY, cnt + 1});
            }
        }
        
        return result;
    }
    
    int[] findStart(String[] maps){
        int[] result = new int[]{-1, -1, -1};
        
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length(); j++){
                if(maps[i].charAt(j) == 'S') {
                    result = new int[]{i, j, 0};
                    break;
                }
            }
        }
        
        return result;
    }
    
    int[] findLever(String[] maps){
        int[] result = new int[]{-1, -1};
        
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length(); j++){
                if(maps[i].charAt(j) == 'L') {
                    result = new int[]{i, j};
                    break;
                }
            }
        }
        
        return result;
    }
    
    boolean inRange(int x, int y){
        return -1 < x && x < row && -1 < y && y < col;    
    }
}