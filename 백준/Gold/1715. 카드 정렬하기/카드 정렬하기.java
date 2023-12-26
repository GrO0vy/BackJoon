import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.offer(sc.nextInt());
        }

        int sum = 0;

        while (pq.size() != 1) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            sum += num1 + num2;
            pq.offer(num1 + num2);
        }

        System.out.print(sum);
    }
}