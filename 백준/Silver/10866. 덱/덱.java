import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch(command){
                case "push_back":
                    deque.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "push_front":
                    deque.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if(deque.isEmpty()) sb.append(-1 + "\n");
                    else sb.append(deque.poll() + "\n");
                    break;
                case "pop_back":
                    if(deque.isEmpty()) sb.append(-1 + "\n");
                    else sb.append(deque.pollLast() + "\n");
                    break;
                case "size":
                    sb.append(deque.size() + "\n");
                    break;
                case "empty":
                    if(deque.isEmpty()) sb.append(1 + "\n");
                    else sb.append(0 + "\n");
                    break;
                case "front":
                    if(deque.isEmpty()) sb.append(-1 + "\n");
                    else sb.append(deque.peek() + "\n");
                    break;
                case "back":
                    if(deque.isEmpty()) sb.append(-1 + "\n");
                    else sb.append(deque.peekLast() + "\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}