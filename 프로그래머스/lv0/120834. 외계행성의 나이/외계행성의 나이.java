class Solution {
    public String solution(int age) {
        String answer = "";
        
        while(age > 0){
            char num = (char)(age % 10 + 97);
            age /= 10;
            answer = num + answer;
        }
        return answer;
    }
}