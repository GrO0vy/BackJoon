import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String regex = "(100+1+|01)+";
        
        if(str.matches(regex)) System.out.println("SUBMARINE");
        else System.out.println("NOISE");
    }
}