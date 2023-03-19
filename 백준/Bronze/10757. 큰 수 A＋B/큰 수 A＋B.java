import java.util.Scanner;
import java.math.BigInteger;

public class Main{
    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
		String n1 = sc.next();
        String n2 = sc.next();
        
        BigInteger number1 = new BigInteger(n1);
        BigInteger number2 = new BigInteger(n2);
        
        System.out.println(number1.add(number2));
        
        sc.close();

    }
}