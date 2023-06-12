class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        
        int start = -1;
        int end = -1;
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 2) end = i;
            if(arr[arr.length-i-1] == 2) start = arr.length-i-1;
        }
        
        if(start == -1 && end == -1){
            answer = new int[]{-1};
        }
        else{
            answer = new int[end - start + 1];
            int idx = 0;
            for(int i = start; i <= end; i++){
                answer[idx++] = arr[i]; 
            }
        }
        return answer;
    }
}