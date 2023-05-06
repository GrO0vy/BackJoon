class Solution {
    public int[] solution(String my_string) {
        my_string = my_string.replaceAll("[a-z]","");
        
        int[] answer = new int[my_string.length()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = Integer.parseInt(String.valueOf(my_string.charAt(i)));
        }
        
        for(int i=0; i<answer.length; i++){
            for(int j=0; j<answer.length-1; j++){
                if(answer[j] > answer[j+1]){
                    int temp = answer[j];
                    answer[j] = answer[j+1];
                    answer[j+1] = temp;
                }
            }
        }
        
        return answer;
    }
}