import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int cnt = 0;
        for(int i = 0; i < N; i++){
            String word = br.readLine();
            Stack<Character> stack = new Stack<>();
            
            for(int j = 0; j < word.length(); j++){
                char letter = word.charAt(j);
                if(stack.isEmpty() || stack.peek() != letter) stack.push(letter);
                else stack.pop();
            }
            
            if(stack.isEmpty()) cnt++;
        }
        
        System.out.println(cnt);
    }
}