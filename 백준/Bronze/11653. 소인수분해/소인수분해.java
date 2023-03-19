import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        int k = 2;
        while(num != 1){
            if(num%k == 0){
                System.out.println(k);
                num/=k;
            }
            else k++;
        }
        
        sc.close();
    }
}