import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count = 0;
        int num = 666;

        while(true){
            int temp = num;
            boolean flag = false;
            while(temp > 0){
                if(temp % 1000 == 666){
                    flag = true;
                    break;
                }
                temp /= 10;
            }
            
            if(flag) count++;
            if(count == N) break;

            num++;
        }

        System.out.println(num);
        sc.close();
    }
}