import java.util.Arrays;
class Solution {
    public int[][] solution(int[][] arr) {
        int[][] answer = {};
        int size = 0;
        
        if(arr.length > arr[0].length) size = arr.length;
        else size = arr[0].length;
        answer = new int[size][size];
        
        for(int i = 0; i < arr.length; i++){
            for(int j =0; j < arr[i].length; j++){
                answer[i][j] = arr[i][j];
            }
        }
        
        if(arr.length > arr[0].length){
            for(int i = 0; i < arr.length; i++){
                int k = arr[0].length;
                for(int j = 0; j < arr.length - arr[0].length; j++){
                    answer[i][k++] = 0;
                }
            }
        }
        else if(arr.length < arr[0].length){
            for(int i = arr.length; i < arr[0].length; i++){
                for(int j = 0; j < arr[0].length; j++){
                    answer[i][j] = 0;
                }
            }
        }
        return answer;
    }
}