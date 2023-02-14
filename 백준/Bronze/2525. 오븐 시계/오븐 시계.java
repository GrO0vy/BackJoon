import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int minutes = sc.nextInt();
        int time = sc.nextInt();
        
        hour = hour + (time/60);
        minutes = minutes + (time%60);
        if(minutes >= 60){
            hour = hour + 1;
            minutes = minutes-60;
        }
        if(hour >= 24) hour = hour - 24;
        System.out.printf("%d %d",hour,minutes);
    }
}