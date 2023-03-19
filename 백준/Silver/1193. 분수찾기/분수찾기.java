import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int x=1;
        int y=1;
        int count=1;
        
        while(count!=num){
            if((x+y)%2==1){
                if(y==1) x++;
                else{
                    x++;
                    y--;
                }
                count++;
            }
            else{
                if(x==1) y++;
                else{
                    y++;
                    x--;
                }
                count++;
            }
        }
        System.out.printf("%d/%d",x,y);
        sc.close();
    }
}