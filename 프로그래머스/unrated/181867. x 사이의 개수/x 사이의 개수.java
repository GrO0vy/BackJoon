class Solution {
    public int[] solution(String myString) {
        int[] answer = {};
        if(myString.charAt(myString.length()-1) == 'x'){
            myString = myString + "";
        }
        
        String[] result = myString.split("x",-1);
        answer = new int[result.length];
        
        for(int i=0; i<result.length; i++){
            answer[i] = result[i].length();
        }
        return answer;
    }
}