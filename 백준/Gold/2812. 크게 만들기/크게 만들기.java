import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < N; i++){
            int num = br.read() - '0';

            while(!stack.isEmpty() && stack.peek() < num && K > 0) {
                stack.pop();
                K--;
            }

            stack.push(num);
        }

        while(!stack.isEmpty() && K > 0) {
            stack.pop();
            K--;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) sb.append(stack.pop());

        System.out.println(sb.reverse().toString());
    }
}