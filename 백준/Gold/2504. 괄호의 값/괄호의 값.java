import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        Stack<Character> stack = new Stack<>();
        int result = 0;
        int temp = 1;

        for(int i = 0; i < word.length(); i++){
            char symbol = word.charAt(i);

            if(symbol == '('){
                stack.push(symbol);
                temp *= 2;
            }
            else if(symbol == '['){
                stack.push(symbol);
                temp *= 3;
            }
            else if(symbol == ')'){
                if(stack.isEmpty() || stack.peek() != '('){
                    result = 0;
                    break;
                }

                if(word.charAt(i - 1) == '(') result += temp;
                temp /= 2;

                stack.pop();
            }

            else{
                if(stack.isEmpty() || stack.peek() != '['){
                    result = 0;
                    break;
                }

                if(word.charAt(i - 1) == '[') result += temp;
                temp /= 3;

                stack.pop();
            }
        }

        System.out.println(!stack.isEmpty() ? 0 : result);
    }
}