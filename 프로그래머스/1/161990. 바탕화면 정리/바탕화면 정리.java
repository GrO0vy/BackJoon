class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        int minRow = Integer.MAX_VALUE;
        int maxRow = Integer.MIN_VALUE;
        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;
        
        for(int i = 0; i < wallpaper.length; i++){
            for(int j = 0; j < wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    if(minRow > i) minRow = i;
                    if(maxRow < i) maxRow = i;
                    if(minCol > j) minCol = j;
                    if(maxCol < j) maxCol = j;
                }
            }
        }
        maxRow += 1;
        maxCol += 1;
        
        answer[0] = minRow;
        answer[1] = minCol;
        answer[2] = maxRow;
        answer[3] = maxCol;
        
        return answer;
    }
}