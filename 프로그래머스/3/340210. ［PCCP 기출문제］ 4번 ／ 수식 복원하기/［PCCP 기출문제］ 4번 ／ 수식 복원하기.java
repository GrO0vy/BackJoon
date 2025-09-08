import java.util.*;

class Solution {
    boolean[] isPossible;
    List<String> waiting;
    
    final String PRINT_FORMAT = "%s %s %s = %s";
    
    public String[] solution(String[] expressions) {
        String[] answer = {};
        
        waiting = new ArrayList<>();
        isPossible = new boolean[10];
        
        Arrays.fill(isPossible, true);
        
        for(int i = 0; i < expressions.length; i++){
            String expression = expressions[i];
            
            expression = expression.replaceAll("\\s+", "");
            String[] numbers = expression.split("\\+|\\-|=");
            String[] operators = expression.split("[0-9]+");
            
            String num1 = numbers[0];
            String num2 = numbers[1];
            String result = numbers[2];
            String operator = operators[1];
            
            for(int format = 2; format <= 9; format++){
                if(isPossible[format]){
                    if(!canCalculate(format, num1, num2, result.equals("X") ? "" : result)){
                        isPossible[format] = false;
                    }
                }
            }
            
            if(result.equals("X")){
                waiting.add(expression);
                continue;
            }
            
            for(int format = 2; format <= 9; format++){
                if(isPossible[format]){
                    if(!result.equals(calculate(num1, operator, num2, format))){
                        isPossible[format] = false;
                    }
                }
            }
        }
        
        answer = new String[waiting.size()];
            
        for(int i = 0; i < waiting.size(); i++){
            String expression = waiting.get(i).replaceAll("\\s+", "");
            String[] numbers = expression.split("\\+|\\-|=");
            String[] operators = expression.split("[0-9]+");
            
            String num1 = numbers[0];
            String num2 = numbers[1];
            String operator = operators[1];
            
            List<String> results = new ArrayList<>();
            
            for(int format = 2; format <= 9; format++){
                if(isPossible[format]){
                    results.add(calculate(num1, operator, num2, format)); 
                }
            }

            if(new HashSet<>(results).size() == 1){
                answer[i] = String.format(PRINT_FORMAT, num1, operator, num2, results.get(0));    
            }
            else{
                answer[i] = String.format(PRINT_FORMAT, num1, operator, num2, "?");        
            }
        }
            
        return answer;
    }
    
    boolean canCalculate(int format, String num1, String num2, String result){
        String validDigits = "0123456789".substring(0, format);
        String all = num1 + num2 + result;

        for (char c : all.toCharArray()) {
            if (validDigits.indexOf(c) == -1) {
                return false;
            }
        }
        
        return true;
    }
    
    String calculate(String num1, String op, String num2, int format){
        int intNum1 = Integer.parseInt(num1, format);
        int intNum2 = Integer.parseInt(num2, format);
        
        if(op.equals("+")){
            return Integer.toString(intNum1 + intNum2, format);    
        }
        else{
            return Integer.toString(intNum1 - intNum2, format);    
        }           
    }
}