class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] numbers = s.split(" ");
        for(int i=0; i<numbers.length; i++){
            if(numbers[i].equals("Z")){
                answer -= Integer.valueOf(numbers[i-1]);
            }
            else{
                answer += Integer.valueOf(numbers[i]);
            }
        }
        return answer;
    }
}