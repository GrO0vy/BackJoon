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
        
        int left = 0;
        int right = bans.length - 1;
        
        while(left <= right){
            int mid = (left + right) / 2;
            
            if(findSequence(bans[mid]) > n){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        
        n += left;
        
        return convertNumberToString(n);
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
            str.insert(0, (char)('a' + sequence % 26));
 
            sequence = sequence / 26 - 1;
        }
        
        return str.toString();
    }
}