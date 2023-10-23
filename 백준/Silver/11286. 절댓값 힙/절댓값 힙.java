import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        PriorityQueue<Integer> pr = new PriorityQueue<>((o1, o2) ->{
            int firstAbs = Math.abs(o1);
            int secondAbs = Math.abs(o2);
            
            if(firstAbs == secondAbs){
                return o1 > o2 ? 1 : -1;
            }
            
            return firstAbs - secondAbs;
        });
        
        for(int i = 0; i < N; i++){
            int num = sc.nextInt();
            if(num  == 0){
                if(pr.isEmpty()) System.out.println(0);
                else System.out.println(pr.poll());
            }
            else pr.add(num);
        }
        
        sc.close();
    }
}