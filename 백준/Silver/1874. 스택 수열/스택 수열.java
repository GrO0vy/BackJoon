import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        
        int count = 1;
        
        Stack<Integer> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();
        
        for(int i = 0; i < T; i++){
            int number = Integer.parseInt(reader.readLine());
            
            for(; count <= number; count++){
                stack.push(count);
                answer.append("+\n");
            }
            
            if(!stack.isEmpty() && stack.peek() == number){
                stack.pop();
                answer.append("-\n");
            }
            else{
                System.out.println("NO");
                return;
            }
        }
        System.out.println(answer);
    }
}