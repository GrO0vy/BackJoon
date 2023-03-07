import java.util.Scanner;
import java.nio.charset.StandardCharsets;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        byte[] bytes = s.getBytes(StandardCharsets.US_ASCII);
        System.out.println(bytes[0]);
        sc.close();
    }
}