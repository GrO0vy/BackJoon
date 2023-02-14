import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int minutes = sc.nextInt();
        
        if(minutes-45 < 0){
            hour = hour-1;
            if(hour<0) hour = 23;
            minutes= 60 + (minutes-45);
        }
        else minutes = minutes - 45;
        
        System.out.printf("%d %d",hour,minutes);
    }
}