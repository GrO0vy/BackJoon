class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        
        for(int i=0; i<numlist.length; i++){
            for(int j=i+1; j<numlist.length; j++){
                int diff = Math.abs(n - numlist[i]);
                int diff2 = Math.abs(n - numlist[j]);
                if((diff == diff2 && numlist[i] < numlist[j]) || diff > diff2){
                    int temp = numlist[i];
                    numlist[i] = numlist[j];
                    numlist[j] = temp;
                }   
            }
        }
        answer = numlist;
        return answer;
    }
}