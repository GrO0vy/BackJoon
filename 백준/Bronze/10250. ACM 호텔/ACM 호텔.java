import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T= sc.nextInt();
        
        for(int i=0; i<T; i++){
            int H = sc.nextInt();
            int W = sc.nextInt();
            int V = sc.nextInt();
            
            int x;
            int y = V%H;
            if(y == 0) y = H;
            if(V%H ==0) x = V/H;
            else x=V/H+1;
            
            System.out.printf("%d%02d\n",y,x);
            }
            
        }
    }
