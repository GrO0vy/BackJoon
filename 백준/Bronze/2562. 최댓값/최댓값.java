import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
    public static void main(String[] args){
        int max;
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<Integer>();
        
        for(int i =0; i<9; i++){
            int num = sc.nextInt();
            nums.add(num);    
        }
        max = Collections.max(nums);
        System.out.println(max);
        System.out.println(nums.indexOf(max)+1);
        sc.close();
    }
}