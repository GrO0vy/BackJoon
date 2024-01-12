import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new LinkedList<>();
        int[] arr = new int[N + 1];

        for(int i = 1; i <= N; i++){
            arr[i] = i;
            deque.offer(i);
        }

        st = new StringTokenizer(br.readLine());
        int answer = 0;

        for(int i = 0; i < M; i++){
            int target = Integer.parseInt(st.nextToken());

            int count = left(deque, target);
            if(count > deque.size() / 2){
                count = right(deque, target) - count;
            }

            answer += count;
            deque.poll();
        }

        System.out.println(answer);
    }

    static int left(Deque<Integer> deque, int target){
        int cnt = 0;
        while(deque.peek() != target){
            deque.offer(deque.poll());
            cnt++;
        }

        return cnt;
    }

    static int right(Deque<Integer> deque, int target){
        int cnt = 0;
        do{
            deque.offerFirst(deque.pollLast());
            cnt++;
        }while(deque.peek() != target);

        return cnt;
    }
}