import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
    
public class Main{
    public static void main(String[] args){
        ArrayList<Integer> result = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        
        for(int i=0 ; i<10; i++){
            int num = sc.nextInt();
            result.add(num%42);
        }
        
        HashSet<Integer> set = new HashSet<Integer>();
        for(int num : result){
            set.add(num);
        }
        System.out.println(set.size());
    }
}