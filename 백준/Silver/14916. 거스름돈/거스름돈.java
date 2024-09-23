import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int count = 0;
        
        if(n % 5 == 0) count = n / 5;
        else{
            while(n > 0){
                n -= 2;
                count++;
                if(n % 5 == 0){
                    count += n / 5;
                    n %= 5;
                    break;
                }
            }    
        }
        
        if(n < 0) System.out.println(-1);
        else System.out.println(count);
    }
}