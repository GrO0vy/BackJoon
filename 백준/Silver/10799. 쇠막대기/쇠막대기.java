import java.io.*;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] simbols = br.readLine().split("");

        Stack<String> stack = new Stack<>();
        int answer = 0;

        for(int i = 0; i < simbols.length; i++){
            if(simbols[i].equals("(")) stack.push(simbols[i]);
            else{
                String top = simbols[i - 1];
                if(top.equals("(")  ) {
                    stack.pop();
                    answer += stack.size();
                }
                else {
                    answer++;
                    stack.pop();
                }
            }
        }

        System.out.println(answer);
    }
}