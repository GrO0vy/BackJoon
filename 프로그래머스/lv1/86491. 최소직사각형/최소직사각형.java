class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int finalWidth = 0;
        int finalHeight = 0;
        
        
        for(int i = 0; i <sizes.length; i++){
            int[] size = sizes[i];
            int width = Math.max(size[0],size[1]);
            int height = Math.min(size[0],size[1]);
            
            finalWidth = Math.max(finalWidth, width);
            finalHeight = Math.max(finalHeight, height);
        }
        
        answer = finalWidth * finalHeight;
        return answer;
    }
}