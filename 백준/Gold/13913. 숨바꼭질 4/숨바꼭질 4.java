import java.util.*;
import java.io.*;

public class Main{
    static int[] time = new int[100001];
    static int[] parent = new int[100001];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Arrays.fill(parent, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        time[N] = 1;

        while(!queue.isEmpty()){
            int current = queue.poll();

            if(current == K) break;

            for(int i = 0; i < 3; i++){
                int next;

                if(i == 0) next = current - 1;
                else if(i == 1) next = current + 1;
                else next = current * 2;

                if(next >= 0 && next <= 100000){
                    if(time[next] == 0){
                        queue.offer(next);
                        time[next] = time[current] + 1;
                        parent[next] = current;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(time[K] - 1 + "\n");

        Stack<Integer> stack = new Stack<>();
        stack.push(K);

        while(parent[stack.peek()] > -1) stack.push(parent[stack.peek()]);
        while(!stack.isEmpty()) sb.append(stack.pop() + " ");

        System.out.println(sb);
    }
}