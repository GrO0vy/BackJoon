class Solution {
    public int solution(String binomial) {
        int answer = 0;
        String[] expression = binomial.split(" ");
        
        int num1 = Integer.parseInt(expression[0]);
        int num2 = Integer.parseInt(expression[2]);
        
        switch(expression[1]){
            case "+": answer = num1 + num2; break;
            case "-": answer = num1 - num2; break;
            case "*": answer = num1 * num2; break;
        }
        
        return answer;
    }
}