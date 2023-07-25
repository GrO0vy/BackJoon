import java.util.*;
import java.io.*;

public class Main{
    private int mapSize;
    
    public void solution() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        mapSize = Integer.parseInt(reader.readLine());
        int[][] map = new int[mapSize][mapSize];
        
        for(int i = 0; i < mapSize; i++){
            StringTokenizer jumpDistance = new StringTokenizer(reader.readLine());
            for(int j = 0; j < mapSize; j++){
                map[i][j] = Integer.parseInt(jumpDistance.nextToken());
            }
        }
        
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0,0});
        
        boolean isTrue = false;
        
        while(!stack.isEmpty()){
            int[] pos = stack.pop();
            int x = pos[0];
            int y = pos[1];
            
            if(map[x][y] == -1){
                isTrue = true;
                break;
            }
            
            if(map[x][y] == 0){
                break;
            }
            
            int distance = map[x][y];
            
            int nextX = x + distance;
            int nextY = y + distance;
            
            if(inRange(nextX, y)) stack.push(new int[]{nextX, y});
            if(inRange(x, nextY)) stack.push(new int[]{x, nextY});
        }
        
        if(isTrue) System.out.println("HaruHaru");
        else System.out.println("Hing");
    }
    
    private boolean inRange(int x, int y){
        return -1 < x && x < mapSize && -1 < y && y < mapSize;
    }
    
    public static void main(String[] args) throws IOException{
        new Main().solution();    
    }
}