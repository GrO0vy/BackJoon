// 1. 상수 배열로 "pi", "ka", "chu" 저장
// 2. pi, ka, chu 를 돌면서 해당 단어로 문자열이 시작하는지 검사한다.
// 3. pi, ka, chu 중 해당 단어로 시작한다면 해당 단어의 길이만큼 길이를 줄인다. (substring)
// 4. 만약 세 단어로 시작하지 않는다면 NO를 출력
// 5.3-4 과정을 문자열 길이가 0 이 될 때 까지 반복

import java.io.*;
import java.util.*;

public class Main{
    static final String[] WORDS = {"pi", "ka", "chu"};
    static final String POSSIBLE = "YES";
    static final String IMPOSSIBLE = "NO";
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        while(str.length() > 0){
            boolean matched = false;
            for(String word : WORDS){
                if(str.startsWith(word)){
                    str = str.substring(Math.min(word.length(), str.length()));
                    matched = true;
                    break;
                }
            }
            
            if(!matched) {
                System.out.println(IMPOSSIBLE);
                return;
            }
        }
        
        System.out.println(POSSIBLE);
    }
}