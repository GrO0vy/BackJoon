import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int sum = 0;
        int min = 10001;
        
        for(int i = M; i<=N; i++){
            int count =0;
            for(int j=1; j<=i; j++){
                if(i%j == 0) {
                    count++;
                }
            }
            if(count == 2) {
                sum+=i;
                if(min>i) min=i;
            }
        }
        if(min == 10001) System.out.println(-1);
        else{
               System.out.println(sum);
               System.out.println(min);
            }
        sc.close();
    }
}