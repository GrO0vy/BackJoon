class Solution {
    public int solution(String my_string) {
        int answer = 0;
        my_string = my_string.replaceAll("[a-zA-Z]"," ");
        my_string = my_string.replaceAll("\\s+"," ");
        my_string = my_string.trim();
        
        if(my_string.length() > 0){
            String[] numbers = my_string.split(" ");

            for(int i=0; i<numbers.length; i++){
                answer += Integer.parseInt(numbers[i]);
            }
        }
       
        return answer;
    }
}