import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();
        int x_dis;
        int y_dis;
        
        if(x>0.5*w) x_dis = w-x;
        else x_dis = x;
        
        if(y>0.5*h) y_dis = h-y;
        else y_dis = y;
        
        if(x_dis<y_dis) System.out.println(x_dis);
        else System.out.println(y_dis);
    }
}