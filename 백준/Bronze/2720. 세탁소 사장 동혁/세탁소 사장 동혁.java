import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int i = 0 ; i<T; i++){
            int total = sc.nextInt();
            int q = total/25;
            total = total - 25*q;
            int d = total/10;
            total = total - 10*d;
            int n = total/5;
            total = total - 5*n;
            int p = total;
            
            System.out.printf("%d %d %d %d\n",q,d,n,p);
            
        }
        sc.close();
    }
}