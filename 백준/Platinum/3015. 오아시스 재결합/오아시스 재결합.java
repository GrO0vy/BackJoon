import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long answer = 0;

        Stack<Node> stack = new Stack<>();

        for(int i = 0; i < N; i++){
            int height = Integer.parseInt(br.readLine());
            Node cur = new Node(height, 1);

            while (!stack.isEmpty() && stack.peek().height <= cur.height) {
                Node top = stack.pop();
                answer += top.cnt;

                if(cur.height == top.height) cur.cnt += top.cnt;
            }

            if(!stack.isEmpty()) answer++;

            stack.push(cur);
        }

        System.out.println(answer);
    }

    static class Node{
        int height;
        int cnt;

        public Node(int height, int cnt){
            this.height = height;
            this.cnt = cnt;
        }
    }
}