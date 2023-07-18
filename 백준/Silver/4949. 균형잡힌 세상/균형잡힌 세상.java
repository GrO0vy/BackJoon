import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String row = reader.readLine();
        while(true){
            if(row.equals(".")) break;

            if(isBalanced(row)) System.out.println("yes");
            else System.out.println("no");

            row = reader.readLine();
        }
    }

    public static boolean isBalanced(String row){
        if(row.contains("(") || row.contains(")") || row.contains("[") || row.contains("]")){
            Stack<Character> stack = new Stack<>();
            stack.clear();

            for(int i = 0; i < row.length(); i++){
                char token = row.charAt(i);
                if(token == '(' || token == '[') stack.push(token);
                else if(token == ')' || token == ']'){
                    if(stack.isEmpty()) return false;
                    char top = stack.pop();
                    if(token == ')' && top != '(') return false;
                    else if(token == ']' && top != '[') return false;
                }
            }
            if(stack.isEmpty()) return true;
            else return false;
        }
        else return true;
    }
}
