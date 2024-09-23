import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        if(n == 1 || n == 3){
            System.out.println(-1);
            return;
        }
        
        int five = 0;
        int two = 0;
        
        if((n % 5) % 2 == 0){
            five = n / 5;
        }
        else{
            five = n / 5 - 1;
        }
        
        two = (n - (5 * five)) / 2;
        
        System.out.println(five + two);
    }
}