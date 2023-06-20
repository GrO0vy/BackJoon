class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i =0; i < arr1.length; i++){
            int num = (arr1[i] | arr2[i]);
            
            String line = "";
            for(int j = 0; j < n; j++){
                line =  (num % 2 == 0 ? " " : "#") + line; 
                num /= 2;
            }
            answer[i] = line;
        }
        return answer;
    }
        
}