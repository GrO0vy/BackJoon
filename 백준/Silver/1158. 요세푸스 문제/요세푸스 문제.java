import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++) queue.offer(i);

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int cnt = 1;
        while(queue.size() > 1){
            int number = queue.poll();
            if(cnt == K) {
                sb.append(number + ", ");
                cnt = 1;
            }
            else {
                queue.offer(number);
                cnt++;
            }
        }
        sb.append(queue.poll() + ">");

        System.out.println(sb);
    }
}