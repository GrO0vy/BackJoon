import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        
        for(int i = 0; i < count; i++){
            String expression = reader.readLine();
            if(isVps(expression)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    
    public static boolean isVps(String expression){
            Stack<Character> stack = new Stack<>();
            stack.clear();
        
            for(int i = 0; i < expression.length(); i++){
                char token = expression.charAt(i);
                if(token == '(') stack.push(token);
                else {
                    if(stack.isEmpty()) return false;
                    stack.pop();
                }
            }
            if(stack.isEmpty()) return true;
            return false;
            
    }
}