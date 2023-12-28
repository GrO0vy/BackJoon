import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int start = N / 5;
        
        int result = -1;
        for(int i = start; i >= 0; i--){
            if( (N - 5*i) % 3 == 0){
                result = i + (N - 5*i) / 3;
                break;
            }
        }
        
        System.out.println(result);
    }
}