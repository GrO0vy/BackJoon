import java.util.*;
class Solution {
    public String[] solution(int[][] line) {
        String[] answer = {};
        
        List<Point> points = new ArrayList<>();
        
        int maxX = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        
        // 교점 구하기
        for(int i = 0; i < line.length; i++){
            long A = line[i][0]; long B = line[i][1]; long E = line[i][2];
            for(int j = i + 1; j < line.length; j++){
                long C = line[j][0]; long D = line[j][1]; long F = line[j][2];
                
                long par = A * D - B * C;
                long xChi = B * F - E * D;
                long yChi = E * C - A * F;
                
                if(par != 0 && xChi % par == 0 && yChi % par == 0)
                {
                    int x = (int)(xChi / par);
                    int y = (int)(yChi / par);
                    
                    maxX = Math.max(maxX, x);
                    minX = Math.min(minX, x);
                    maxY = Math.max(maxY, y);
                    minY = Math.min(minY, y);
                    
                    points.add(new Point(x, y));        
                }
            }
        }
        
        int height = maxY - minY + 1;
        int width = maxX - minX + 1;
        
        answer = new String[height];
        Arrays.fill(answer, ".".repeat(width));
        
        StringBuilder sb = new StringBuilder();
    
        for(Point point: points){
            int y = maxY - point.y;
            int x = point.x - minX;
            
            sb = new StringBuilder(answer[y]);
            sb.setCharAt(x, '*');
            answer[y] = sb.toString();
        }
        
        return answer;
    }
    
    class Point{
        int x;
        int y;
        
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}