import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = 0;
        
        for(int i=0; i<N; i++){
            int n = sc.nextInt();
            int count =0;
            for(int j=1; j<=n; j++){
                if(n%j==0) count++;
            }
            if(count == 2) result++;
        }
        System.out.println(result);
    }
}