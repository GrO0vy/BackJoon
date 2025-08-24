import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {
        String answer = "";
        Arrays.sort(bans, new Comparator<>(){
            public int compare(String o1, String o2){
                if(o1.length() != o2.length()) return o1.length() - o2.length();
                
                return o1.compareTo(o2);
            }
        });
        
        int removed = 0;
        for(String ban: bans){
            long sequence = findSequence(ban);
            
            if(n + removed >= sequence) removed++;
            else break;
        }
       
        return convertNumberToString(n + removed);
    }
    
    long findSequence(String str){
        long sequence = 0;
        
        for(int i = 0; i < str.length(); i++){
            sequence = sequence * 26 + (str.charAt(i) - 'a') + 1;
        }
        
        return sequence;
    }
    
    String convertNumberToString(long sequence){
        StringBuilder str = new StringBuilder();
        
        while(sequence > 0){
            sequence--;
            str.insert(0, (char)('a' + (sequence % 26)));
 
            sequence = sequence / 26;
        }
        
        return str.toString();
    }
}