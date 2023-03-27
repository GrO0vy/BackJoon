import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int x_max = -10000;
        int x_min = 10000;
        int y_max = -10000;
        int y_min = 10000;
        int result;
        
        for(int i = 0; i<N; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
                
            if(x_max < x) x_max = x;
            if(x_min > x) x_min = x;
            if(y_max < y) y_max = y;
            if(y_min > y) y_min = y;
        }    
        
        if(x_max == x_min || y_max == y_min) result = 0;
        else result = (x_max-x_min) * (y_max-y_min);
        
        System.out.println(result);
        sc.close();
    }
}