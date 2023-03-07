import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();
        int M =sc.nextInt();
        int[] nums = new int[N];
        
        for(int i = 0; i<N; i++){
            nums[i] = i+1;
        }
        
        for(int count = 0; count<M; count++){
            int i = sc.nextInt();
            int j = sc.nextInt();
            
            int temp = nums[i-1];
            nums[i-1] = nums[j-1];
            nums[j-1] = temp;
        }
        
        for(int num : nums){
            System.out.print(num+" ");
        }
        sc.close();
    }
}