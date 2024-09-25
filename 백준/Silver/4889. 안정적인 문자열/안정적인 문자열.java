import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        StringBuilder sb = new StringBuilder();

        int T = 1;

        while(true){
            input = br.readLine();

            if(input.contains("-")) break;

            Stack<Character> stack = new Stack<>();

            int count = 0;

            for(int i = 0; i < input.length(); i++){
                char c  = input.charAt(i);

                if(c == '{') stack.push(c);
                else{
                    if(stack.isEmpty()){
                        count++;
                        stack.push('{');
                    }
                    else stack.pop();
                }
            }

            count += stack.size() / 2;

            sb.append(String.format("%d. %d\n",T++ , count));
        }

        System.out.println(sb);
    }
}