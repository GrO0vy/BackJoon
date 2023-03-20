import java.util.Scanner;
import java.math.BigInteger;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        BigInteger num = new BigInteger(n);
        
        BigInteger four = new BigInteger("4");
        System.out.println(num.multiply(four));
        sc.close();
    }
}