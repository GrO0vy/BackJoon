import java.util.Arrays;
class Solution {
    public int[][] solution(int[][] arr) {
        int[][] answer = {};
        int size = Math.max(arr.length,arr[0].length);
        answer = new int[size][size];
        
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                answer[i][j] = arr[i][j];
            }
        }
        return answer;
    }
}