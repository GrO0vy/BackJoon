import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int number = sc.nextInt();
        for(int i=1; i<=number; i++){
            sum+=i;
        }
        System.out.println(sum);
    }
}