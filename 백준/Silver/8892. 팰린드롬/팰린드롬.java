// 1. 이중 for 문으로 단어 두 개 선택
// 2. 두 단어를 연결 한 다음 연결한 단어를 팰린드롬인지 판단
// 3. 팰린드롬이라면 출력 후 for 문 종료
// 4. 팰린드롬을 만들 수 없다면 0 출력

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < T; i++){
            int cntWords = Integer.parseInt(br.readLine());
            
            String[] words = new String[cntWords];
            for(int j = 0; j < cntWords; j++){
                words[j] = br.readLine();
            }
            
            boolean flag = false;
            
            for(int j = 0; j < cntWords; j++){
                for(int k = 0; k < cntWords; k++){
                    if(j == k) continue;
                    
                    String password = words[j] + words[k];
                    if(isPalindrome(password)){
                        sb.append(password + "\n");
                        flag = true;
                        break;
                    }
                }
                
                if(flag) break;
            }
            
            if(!flag) sb.append("0\n");
        }

        System.out.println(sb.toString());
    }
    
    static boolean isPalindrome(String password){
        int left = 0;
        int right = password.length() - 1;
        
        while(left <= right){
            if(password.charAt(left) != password.charAt(right)) return false;
            
            left++;
            right--;
        }
        
        return true;
    }
}