import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long minus = 0;
        
        for(int i = 1; i<n; i++){
            minus +=i;
        }
        
        System.out.println(n*(n-1)-minus);
        System.out.println(2);
        
        sc.close();
    }
}