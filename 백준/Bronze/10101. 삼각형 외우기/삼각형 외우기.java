import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int sum=0;
        String result;
        ArrayList<Integer> angles = new ArrayList<Integer>();
        
        for(int i=0; i<3; i++){
            int n = sc.nextInt();
            angles.add(n);
        }
        
        HashSet<Integer> set = new HashSet<Integer>(angles);
        
        for(int a : angles) sum+=a;
        
        if(sum != 180) result = "Error";
        else{
            if(set.size() == 1) result = "Equilateral";
            else if(set.size() == 2) result = "Isosceles";
            else result = "Scalene";
        }
        
        System.out.println(result);
        sc.close();        
    }
}