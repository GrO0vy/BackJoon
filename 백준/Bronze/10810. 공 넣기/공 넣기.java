import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] basket = new int[N];
        
        for(int count=0; count<M; count++){
            int i = sc.nextInt();
            int j = sc.nextInt();
            int k = sc.nextInt();
            
            for(int index=i-1; index<j; index++){
                basket[index] =k;
            }
        }
        for(int i =0; i<N; i++){
            System.out.print(basket[i]+" ");
        }
    }
}