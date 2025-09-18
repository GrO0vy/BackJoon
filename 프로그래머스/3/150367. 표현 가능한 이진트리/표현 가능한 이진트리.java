import java.util.*;

class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            long number = numbers[i];
            
            // System.out.println(getStr(number, getLength(number)));
            
            if(isPossible(getStr(number, getLength(number)))){
                answer[i] = 1;    
            }
        }
        
        return answer;
    }
    
    int getLength(long number){
        int length = 0;
        
        while(number > ((long) Math.pow(2, length)) - 1){
            length = length * 2 + 1;        
        }
        
        return length;
    }
    
    String getStr(long number, int length){
        StringBuilder sb = new StringBuilder(Long.toString(number, 2));
        while(sb.length() < length) sb.insert(0, "0");
        
        return sb.toString();
    }
    
    boolean isPossible(String str){
        if(str.length() == 0) return true;
        
        int root = str.length() / 2;
        
        String left = str.substring(0, root);
        String right = str.substring(root + 1);
        
        if(str.charAt(root) == '0'){
            return !containsOne(left) && !containsOne(right);        
        }
        
        return isPossible(left) && isPossible(right);
    }
    
    boolean containsOne(String str){
        if(str.length() == 0) return false;
        
        int root = str.length() / 2;
        
        if(str.charAt(root) == '1') return true;
        
        String left = str.substring(0, root);
        String right = str.substring(root + 1);
        
        return containsOne(left) || containsOne(right);
    }
}