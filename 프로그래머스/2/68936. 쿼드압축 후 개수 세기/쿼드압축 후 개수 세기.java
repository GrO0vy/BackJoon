class Solution {
    int[] answer;
    
    public int[] solution(int[][] arr) {
        answer = new int[2];
        recursion(0, 0, arr.length, arr);
        
        return answer;
    }
    
    void recursion(int x, int y, int len, int[][] arr){
        if(isAllSame(x, y, len, arr)) answer[arr[x][y]]++;
        else{
            int nextLen = len / 2;
            recursion(x, y, nextLen, arr);
            recursion(x, y + nextLen, nextLen, arr);
            recursion(x + nextLen, y, nextLen, arr);
            recursion(x + nextLen, y + nextLen, nextLen, arr);
        }
    }
    
    boolean isAllSame(int x, int y, int len, int[][] arr){
        for(int i = x; i < x + len; i++){
            for(int j = y; j < y + len; j++){
                if(arr[i][j] != arr[x][y]) return false;
            }
        }
        return true;
    }
}