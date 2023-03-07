import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<Integer> nums = new ArrayList<Integer>();
        
        for(int i=0; i<N; i++){
            nums.add(i+1);
        }
        
        for(int count=0; count<M; count++){
            int i = sc.nextInt();
            int j = sc.nextInt();
            
            ArrayList<Integer> slice = new ArrayList<Integer>(nums.subList(i-1,j));
            Collections.reverse(slice);
            int sliceIndex=0;
            
            for(int index = i-1; index<j; index++){
                nums.set(index,slice.get(sliceIndex));
                sliceIndex++;
            }
        }
        
        for(int num : nums){
            System.out.print(num+" ");
        }
        sc.close();
    }
}