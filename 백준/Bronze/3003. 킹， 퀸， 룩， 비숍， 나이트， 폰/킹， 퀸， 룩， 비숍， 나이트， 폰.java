import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int q = sc.nextInt();
        int l = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        int p = sc.nextInt();
        
        k = 1-k;
        q = 1-q;
        l = 2-l;
        b = 2-b;
        n = 2-n;
        p = 8-p;
        
        System.out.printf("%d %d %d %d %d %d",k,q,l,b,n,p);
        
        sc.close();
    }
}