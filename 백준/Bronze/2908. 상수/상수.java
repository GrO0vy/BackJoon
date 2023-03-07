import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
                Scanner sc = new Scanner(System.in);
        String n1 = sc.next();
        String n2 = sc.next();
      
        ArrayList<String> numbers = new ArrayList<String>();
        numbers.add(n1);
        numbers.add(n2);
        ArrayList<String> number = new ArrayList<String>();
        
        for(int i=0; i<2; i++){
            for(int j=0; j<3; j++){
                number.add(String.valueOf(numbers.get(i).charAt(j)));
            }
            
            Collections.reverse(number);
            
      
            String temp="";
            for(String result : number){
            	//System.out.println(result);
                temp+=result;
            }
            numbers.set(i,temp);
            number.clear();
        }
        
        int num1 = Integer.parseInt(numbers.get(0));
        int num2 = Integer.parseInt(numbers.get(1));
        if(num1>num2){
            System.out.println(num1);
        }
        else{
            System.out.println(num2);
        }
    }
}