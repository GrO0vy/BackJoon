import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        
        for(int i=97; i<123; i++){
            System.out.printf("%d ",s.indexOf((char)i));
        }                               
        sc.close();
    }
}