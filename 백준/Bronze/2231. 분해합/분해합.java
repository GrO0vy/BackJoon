import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int result = 0;
        
        for(int i = 1; i <= N; i++){
            int temp = i;
            int num = i;
            while(num > 0){
                temp += num % 10;
                num /= 10;
            }
            
            if(temp == N) {
                result = i;
                break;
            }
        }
        
        System.out.println(result);
    }
}