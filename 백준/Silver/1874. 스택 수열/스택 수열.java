import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int next = 1;

        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num >= next) {
                while (num >= next) {
                    stack.push(next++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                int top = stack.pop();
                if (num > top) {
                    System.out.println("NO");
                    return;
                }
                else{
                    sb.append("-\n");
                }
            }
        }

        System.out.println(sb);
    }
}