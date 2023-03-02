import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int lessThan = sc.nextInt();
        List<Integer> numbers = new ArrayList<Integer>();
        
        for(int i=0; i<count; i++){
            int number = sc.nextInt();
            numbers.add(number);
        }
        
        for(int l : numbers){
            if(l<lessThan) System.out.print(l+" ");
        }
        sc.close();
    }
}