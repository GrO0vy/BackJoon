import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main{
    public static void main(String[] args){
        List<Integer> stu = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        
        for(int i=0; i<30; i++){
            stu.add(i+1);
        }
        
        for(int i =0; i<28; i++){
            int attend = sc.nextInt();
            stu.remove(Integer.valueOf(attend));
        }
        
        Collections.sort(stu);
        
        for(int student : stu){
            System.out.println(student);
        }
        sc.close();
    }
}