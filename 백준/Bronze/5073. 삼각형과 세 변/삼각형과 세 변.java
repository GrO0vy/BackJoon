import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String result="";
        
        while(true){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();
            
            
            if(n1+n2+n3 == 0) break;
            
            ArrayList<Integer> angles = new ArrayList<Integer>();
            angles.add(n1);
            angles.add(n2);
            angles.add(n3);
            
            int max = Collections.max(angles);
            
            HashSet<Integer> set = new HashSet<>(angles);
            
            if(n1+n2+n3-max <= max) result = "Invalid";
            else{
                if(set.size() == 3) result = "Scalene";
                else if(set.size() == 2) result = "Isosceles";
                else result = "Equilateral";
            }
            System.out.println(result);
        }
        sc.close();
    }
}