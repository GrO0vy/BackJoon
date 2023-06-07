class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int[] answer = {};
        int size = 0;
        for(int i = 0; i < 2; i++){
            size += intervals[i][1] - intervals[i][0] + 1;
        }
        
        answer = new int[size];
        
        int idx = 0;
        for(int i = 0; i < 2; i++){
            for(int j = intervals[i][0]; j <= intervals[i][1]; j++){
                answer[idx++] = arr[j];
            }
        }
        return answer;
    }
}