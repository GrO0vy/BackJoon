import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int iter = sc.nextInt();
        String s = sc.next();
        int total = 0;
        
        for(int i =0; i<iter; i++){
            int number = Character.getNumericValue(s.charAt(i));
            total += number;
        }
        System.out.println(total);
        sc.close();
    }
}