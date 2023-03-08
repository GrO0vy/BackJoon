import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int cycle = sc.nextInt();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int i=0; i<size; i++){
            numbers.add(i+1);
        }
        
        for(int i=0; i<cycle; i++){
            int first = sc.nextInt()-1;
            int last = sc.nextInt()-1;
            int standard = sc.nextInt()-1;
            
            for(int j=first; j<standard; j++){
                int temp = numbers.get(first);
                numbers.remove(first);
                numbers.add(last,temp);
            }
        }
        
        for(int i=0; i<numbers.size(); i++){
            System.out.printf("%d ",numbers.get(i));
        }
        sc.close();
    }
}