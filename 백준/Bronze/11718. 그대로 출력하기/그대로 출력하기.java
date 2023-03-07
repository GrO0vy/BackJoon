import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            if(sc.hasNext() == false) break;
            String s = sc.nextLine();
            System.out.println(s);
        }
            
    }
}