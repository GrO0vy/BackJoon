import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            String commands = br.readLine();
            int N = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine().replace("[","").replace("]",""), ",");
            for(int j = 0; j < N; j++){
                deque.offer(Integer.parseInt(st.nextToken()));
            }

            boolean isReverse = false;
            boolean isError = false;
            StringBuilder sb = new StringBuilder("");

            for(int j = 0; j < commands.length(); j++){
                char command = commands.charAt(j);
                if(command == 'R') isReverse = !(isReverse);
                else{
                    if(deque.isEmpty()){
                        isError = true;
                        break;
                    }

                    if(isReverse) deque.pollLast();
                    else deque.poll();
                }
            }

            if(isError) sb.append("error\n");
            else{
                sb.append("[");
                if(!deque.isEmpty()){
                    if(isReverse){
                        while(deque.size() > 1) sb.append(deque.pollLast() + ",");
                    }
                    else{
                        while(deque.size() > 1) sb.append(deque.poll() + ",");
                    }
                    sb.append(deque.poll() + "]\n");
                }
                else sb.append("]\n");
            }

            System.out.print(sb);
        }
    }
}