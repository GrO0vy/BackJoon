class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        while(!isEquals(arr)){
            for(int i = 0; i < arr.length; i++){
                if(arr[i] % 2 ==0){
                    if(arr[i] >= 50) arr[i] = arr[i] / 2;
                }
            else{
                if(arr[i] < 50) arr[i] = arr[i] * 2 + 1;
                }
            }
            answer++;
        }
        
        return answer;
    }
    
    public boolean isEquals(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % 2 ==0){
                if(arr[i] >= 50) return false; 
            }
            else{
                if(arr[i] < 50) return false;
            }
        }
        return true;
    }
}