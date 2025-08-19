import java.io.*;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String explode = br.readLine();

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            stack.push(str.charAt(i));

            boolean isExplode = false;

            if(stack.size() >= explode.length()){
                isExplode = true;

                for(int j = 0; j < explode.length(); j++){
                    if(stack.get(stack.size() - explode.length() + j) != explode.charAt(j)){
                        isExplode = false;
                        break;
                    }
                }
            }

            if(isExplode){
                for(int j = 0; j < explode.length(); j++) stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) sb.append(stack.pop());

        System.out.println(sb.toString().isEmpty() ? "FRULA" : sb.reverse().toString());
    }
}