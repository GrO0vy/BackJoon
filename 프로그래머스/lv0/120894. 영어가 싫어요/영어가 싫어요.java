class Solution {
    public long solution(String numbers) {
        long answer = 0;
        String[] number = {"zero", "one", "two", "three", "four", "five", 
                           "six", "seven", "eight", "nine"};
        
        while(numbers.length() > 0){
            for(int i=0;  i<number.length; i++){
                if(numbers.indexOf(number[i]) == 0) {
                    answer *= 10;
                    answer += i;
                    numbers = numbers.replaceFirst(number[i],"");
                    break;
                }
            }
        }
        return answer;
    }
}