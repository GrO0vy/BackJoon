import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();
        
        ArrayList<Integer> angles = new ArrayList<Integer>();
        angles.add(n1);
        angles.add(n2);
        angles.add(n3);
        
        int max = Collections.max(angles);
        
        if(max < n1+n2+n3-max) System.out.println(n1+n2+n3);
        else{
            Collections.sort(angles);
            max = n1+n2+n3-max-1;
            angles.set(2,max);
            System.out.println(angles.get(0)+angles.get(1)+angles.get(2));
        }
        sc.close();
    }
}