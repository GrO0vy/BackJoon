import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = conversion(p);
        return answer;
    }
    
    String conversion(String s){
        if(s == "") return "";
        
        int divPoint = divide(s);
        
        String u = s.substring(0, divPoint + 1);
        String v = "";
        if(divPoint < s.length() - 1) v = s.substring(divPoint + 1);
        
        if(correct(u)) return u + conversion(v);
        else{
            String temp = "(" + conversion(v) + ")";
            String result = temp + reverse(u.substring(1, u.length() - 1));
            
            return result;
        }
    }
    
    int divide(String s){
        int left = 0;
        int right = 0;
        int idx = -1;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') left++;
            else right++;
            
            if(left > 0 && right > 0 && left == right) {
                idx = i;
                break;
            }
        }
        
        return idx;
    }
    
    boolean correct(String s){
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') stack.push('(');
            else{
                if(stack.isEmpty()) return false;
                else stack.pop();
            }
        }
        
        if(stack.isEmpty()) return true;
        else return false;
    }
    
    String reverse(String s){
        String result = "";
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') result += ')';
            else result += '(';
        }
        
        return result;
    }
}