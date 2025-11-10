// 1. TARGET 선언 -> UCPC
// 2. 공백단위로 주어진 문자열을 split
// 3. split 된 문자열을 모두 순회하면서 UCPC 가 차례대로 포함되는지 확인한다
// 4. 만약 U가 확인되었다면 이후 문자열에서는 C  그 다음은 P 그 다음은 C가 있는지 확인한다.
// 5. 만약 UCPC 모두 확인되면 성공 문자열, 확인 못하면 실패 문자열 출력

import java.util.*;
import java.io.*;

public class Main{
    static final char[] TARGET = {'U', 'C', 'P', 'C'};
    static final String SUCCESS = "I love UCPC";
    static final String FAIL = "I hate UCPC";
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        if(isPossible(str)){
            System.out.println(SUCCESS);    
        }
        else{
            System.out.println(FAIL);    
        }
    }
    
    static boolean isPossible(String str){
        int idx = 0;
        
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == TARGET[idx]) idx++;
            if(idx == TARGET.length) return true;
        }
        
        return false;
    }
}