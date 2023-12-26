import java.util.*;

public class Main{
   public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> positive = new PriorityQueue<>((o1, o2) ->{
            return o2 - o1;
        });

        PriorityQueue<Integer> negative = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
            int num = sc.nextInt();
            if(num > 0) positive.offer(num);
            else negative.offer(num);
        }

        int sum = 0;

        while(!positive.isEmpty()){
            int num1 = positive.poll();
            if(!positive.isEmpty()){
                int num2 = positive.poll();
                if(num1 == 1 || num2 == 1) sum += num1 + num2;
                else sum += num1 * num2;
            }
            else sum += num1;
        }

        while(!negative.isEmpty()){
            int num1 = negative.poll();
            if(!negative.isEmpty()){
                int num2 = negative.poll();
                sum += num1 * num2;
            }
            else sum += num1;
        }

        System.out.println(sum);
    }
}