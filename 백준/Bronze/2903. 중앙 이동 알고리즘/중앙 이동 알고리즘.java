import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int result = 2;
        
        for(int i=0; i<n; i++){
            result = result+(int)Math.pow(2,i);
        }
        
        result = result * result;
        
        System.out.println(result);
        sc.close();
    }
}