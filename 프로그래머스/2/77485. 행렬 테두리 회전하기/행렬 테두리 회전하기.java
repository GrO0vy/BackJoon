import java.util.*;

class Solution {
    int[] answer;
    int idx = 0;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        answer = new int[queries.length];
        
        int[][] arr = new int[rows + 1][columns + 1];
        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= columns; j++){
                arr[i][j] = (i - 1) * columns + j;
            }
        }
        
        for(int[] query: queries){
            rotation(arr, query[0], query[1], query[2], query[3]);
        }
        
        return answer;
    }
    
    void rotation(int[][] arr, int x1, int y1, int x2, int y2){
        Deque<Integer> deque = new LinkedList<>();
        answer[idx++] = min(arr, x1, y1, x2, y2, deque);
        
        deque.offerFirst(deque.pollLast());
        
        for(int i = y1; i < y2; i++){
            arr[x1][i] = deque.poll();
        }
        
        for(int i = x1; i < x2; i++){
            arr[i][y2] = deque.poll();
        }
        
        for(int i = y2; i > y1; i--){
            arr[x2][i] = deque.poll();
        }
        
        for(int i = x2; i > x1; i--){
            arr[i][y1] = deque.poll();
        }
    }
    
    int min(int[][] arr, int x1, int y1, int x2, int y2, Deque<Integer> deque){
        int result = Integer.MAX_VALUE;
        
        for(int i = y1; i < y2; i++){
            deque.offer(arr[x1][i]);
            result = Math.min(result, arr[x1][i]);
        }
        
        for(int i = x1; i < x2; i++){
            deque.offer(arr[i][y2]);
            result = Math.min(result, arr[i][y2]);
        }
        
        for(int i = y2; i > y1; i--){
            deque.offer(arr[x2][i]);
            result = Math.min(result, arr[x2][i]);
        }
        
        for(int i = x2; i > x1; i--){
            deque.offer(arr[i][y1]);
            result = Math.min(result, arr[i][y1]);
        }
        
        return result;
    }
}