import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int result = n1*n2;
        
        for(int i=0; i<3; i++){
            System.out.println(n1*(n2%10));
            n2= n2/10;
        }
        System.out.println(result);
            
    }
}