import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int total_count = sc.nextInt();
        int sum = 0;
        
        for(int i=0; i<total_count; i++){
            int price = sc.nextInt();
            int count = sc.nextInt();
            sum += (price*count);
        }
        if(sum == total) System.out.println("Yes");
        else System.out.println("No");
    }
}