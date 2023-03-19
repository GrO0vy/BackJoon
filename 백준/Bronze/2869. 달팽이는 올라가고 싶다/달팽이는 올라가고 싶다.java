import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int morning = sc.nextInt();
        int night = sc.nextInt();
        int tree = sc.nextInt();
        int day = 0;
        
        day = (tree-night) / (morning-night);
        
        if(((tree-night) % (morning-night))!=0) day++;
        
        System.out.println(day);
    }
}