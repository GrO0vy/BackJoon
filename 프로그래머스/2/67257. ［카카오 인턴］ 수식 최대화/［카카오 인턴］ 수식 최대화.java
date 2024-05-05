import java.util.*;

class Solution {
    public long solution(String expression) {
        long answer = 0;
        String[][] op = {{"*", "+", "-"}, {"*", "-", "+"}, {"+", "*", "-"},
                         {"+", "-", "*"}, {"-", "*", "+"}, {"-", "+", "*"}};
        
        List<String> exp = new ArrayList<>();
        int start = 0;
        for(int i = 0; i < expression.length(); i++){
            if(expression.charAt(i) == '+' || expression.charAt(i) == '-' || 
               expression.charAt(i) == '*')
            {
                exp.add(expression.substring(start, i));
                exp.add(expression.charAt(i) + "");
                start = i + 1;
            }
        }
        exp.add(expression.substring(start));
        
        for(int i = 0; i < op.length; i++){
            List<String> subExp = new ArrayList<>(exp);
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < subExp.size(); k++){
                    if(op[i][j].equals(subExp.get(k))){
                        subExp.set(k - 1, calculation(subExp.get(k - 1), subExp.get( k + 1), subExp.get(k)));
                        subExp.remove(k);
                        subExp.remove(k);
                        k--;
                    }
                }
            }
            
            answer = Math.max(answer, Math.abs(Long.parseLong(subExp.get(0))));
        }
        return answer;
    }
    
    String calculation(String num1, String num2, String op){
        Long n1 = Long.parseLong(num1);
        Long n2 = Long.parseLong(num2);
        
        if(op.equals("+")) return String.valueOf(n1 + n2);
        else if(op.equals("-")) return String.valueOf(n1 - n2);
        else return String.valueOf(n1 * n2);
    }
}