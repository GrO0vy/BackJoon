class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for(int i = 0; i < balls.length; i++){
            int distance = Integer.MAX_VALUE;
            
            int width = Math.abs(startX - balls[i][0]);
            int height = startY + balls[i][1];
            if(width != 0 || startY < balls[i][1])
                distance = (int)Math.min(distance, width*width + height*height);
            
            System.out.printf("%d %d\n", i, distance);
            
            height = 2 * n - (startY + balls[i][1]);
            if(width != 0 || startY > balls[i][1])
                distance = (int)Math.min(distance, width*width + height*height);
            
            System.out.printf("%d %d\n", i, distance);
            
            width = Math.abs(startY - balls[i][1]);
            height = startX + balls[i][0];
            if(width != 0 || startX < balls[i][0])
                distance = (int)Math.min(distance, width*width + height*height);
            
            System.out.printf("%d %d\n", i, distance);
            
            height = 2 * m - (startX + balls[i][0]);
            if(width != 0 || startX > balls[i][0])
                distance = (int)Math.min(distance, width*width + height*height);
      
            answer[i] = distance;
        }
        
        return answer;
    }
}