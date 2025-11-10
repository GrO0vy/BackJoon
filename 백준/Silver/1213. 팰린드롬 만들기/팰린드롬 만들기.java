// 1. 알파벳 개수를 모두 센다.
// 2. 홀수개인 알파벳이 두 개 이상 있다면 불가능
// 3. 알파벳 내림차순으로 문자열의 왼쪽, 오른쪽 끝에 (개수 / 2) 개 추가
// 4. 마지막에 홀수개인 알파벳이 존재한다면 중간에 알파벳 하나 삽입

import java.io.*;
import java.util.*;

public class Main{
    static final String IMPOSSIBLE = "I'm Sorry Hansoo";
    static final char EMPTY = 'e';
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        
        if(name.length() < 2){
            System.out.println(name);
            return;
        }
        
        Map<Character, Integer> charMap = new HashMap<>();
        
        for(int i = 0; i < name.length(); i++){
            char c = name.charAt(i);
            
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        
        if(!isPossible(charMap)){
            System.out.println(IMPOSSIBLE);
        }
        else{
            System.out.println(getPalindrome(charMap));
        }
    }
    
    static boolean isPossible(Map<Character, Integer> charMap){
        int cntOdd = 0;
        
        for(int cnt: charMap.values()){
            if(cnt % 2 == 1) cntOdd++;
            
            if(cntOdd > 1) return false;
        }
            
        return true;
    }
    
    static String getPalindrome(Map<Character, Integer> charMap){
        StringBuilder sb = new StringBuilder();
        
        char oddChar = EMPTY;
        
        for(char c = 'Z'; c >= 'A'; c--){
            if(charMap.containsKey(c)){
                for(int i = 0; i < charMap.get(c) / 2; i++){
                    sb.insert(0, c);
                    sb.append(c);
                }
                
                if(charMap.get(c) % 2 == 1) oddChar = c;
            }
        }
        
        if(oddChar != EMPTY) sb.insert(sb.length() / 2, oddChar);
        
        return sb.toString();
    }
}