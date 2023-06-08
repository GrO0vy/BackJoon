class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        
        String size = Integer.toBinaryString(arr.length);
        
        if(!(size.length() - size.replace("1","").length() == 1)){
            size = "1" + "0".repeat(size.length());
        }
    
        answer = new int[Integer.parseInt(size,2)];
        
        for(int i = 0; i < arr.length; i++){
            answer[i] = arr[i];
        }
        
        return answer;
    }
}