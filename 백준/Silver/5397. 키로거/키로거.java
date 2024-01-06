import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++){
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            char[] pw = br.readLine().toCharArray();

            for(int j = 0; j < pw.length; j++){
                if(pw[j] == '<') {
                    if (!left.isEmpty()) right.push(left.pop());
                }
                else if(pw[j] == '>') {
                    if (!right.isEmpty()) left.push(right.pop());
                }
                else if(pw[j] == '-') {
                    if (!left.isEmpty()) left.pop();
                }
                else left.push(pw[j]);
            }

            while(!left.isEmpty()) right.push(left.pop());
            while(!right.isEmpty()) sb.append(right.pop());
            sb.append("\n");
        }
        System.out.println(sb);
    }
}