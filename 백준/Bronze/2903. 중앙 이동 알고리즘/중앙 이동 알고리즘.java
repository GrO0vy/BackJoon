import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        
        int result = (int)Math.pow(1 + (int)Math.pow(2,n),2);
        
        System.out.println(result);
        sc.close();
    }
}