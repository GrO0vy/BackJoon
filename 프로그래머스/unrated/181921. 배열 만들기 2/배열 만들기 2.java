class Solution {
    public static boolean isZeroOrFive(int num){
        while(num > 0){
            int remainder = num % 10;
            if(remainder % 5 == 0) num /= 10;
            else return false;
        }
        return true;
    }
    
    public static int[] returnNewArr(int[] answer ,int length ,int num){
         int[] newArr = new int[length+1];
                for(int i = 0; i<length; i++){
                    newArr[i] = answer[i];
                }
                newArr[length] = num;
        
        return newArr; 
    }
    
    public int[] solution(int l, int r) {
        int[] answer = {};
        
        for(int i = l; i<=r; i++){
            if(isZeroOrFive(i)){
                answer = returnNewArr(answer,answer.length,i);
            }
        }
        
        if(answer.length == 0) answer = returnNewArr(answer,answer.length,-1);
    
        return answer;
    }
}