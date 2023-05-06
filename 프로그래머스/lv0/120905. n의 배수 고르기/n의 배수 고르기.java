class Solution {
    private int[] returnNewArr(int[] answer, int num){
        int[] newArr = new int[answer.length+1];
        for(int i=0; i<answer.length; i++){
            newArr[i] = answer[i];
        }
        newArr[answer.length] = num;
        return newArr;
    }
    
    public int[] solution(int n, int[] numlist) {
        int[] answer = {};
        for(int i=0; i<numlist.length; i++){
            if(numlist[i] % n == 0) answer = returnNewArr(answer,numlist[i]);
        }
        
        return answer;
    }
}