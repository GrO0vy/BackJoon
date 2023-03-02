import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int answer=0;
        int count = sc.nextInt();
        
        List<Integer> numbers = new ArrayList<Integer>();
        for(int i=0; i<count; i++){
            int number = sc.nextInt();
            numbers.add(number);
        }
        
        int number = sc.nextInt();
        
        for(int l : numbers){
            if(l == number) answer+=1;
        }
        
        System.out.println(answer);
        sc.close();
    }
}