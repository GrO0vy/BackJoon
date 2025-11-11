// 1. 문자열을 알파벳 소문자를 기준으로 분리한다.
// 2. 분리한 문자열의 맨 앞 0을 제거한다.
// 3. 길이가 긴 순, 사전 순으로 뒤쪽인 숫자부터 출력한다.

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        List<String> numbers = new ArrayList<>();
        
        for(int i = 0; i < N; i++){
            String[] arr = br.readLine().split("[a-z]+");
            
            for(String n: arr){
                if(n.length() == 0) continue;
                
                while(n.length() > 1 && n.startsWith("0")){
                    n = n.substring(1);   
                }
                
                numbers.add(n);
            }
        }
        
        Collections.sort(numbers, new Comparator<>(){
            public int compare(String o1, String o2){
                if(o1.length() != o2.length()) return o1.length() - o2.length();
                
                return o1.compareTo(o2);
            }    
        });
        
        StringBuilder sb = new StringBuilder();
        for(String number: numbers) sb.append(number + "\n");
        
        System.out.println(sb.toString());
    }
}