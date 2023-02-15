import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
	        int n1 = sc.nextInt();
	        int n2 = sc.nextInt();
	        int n3 = sc.nextInt();
	        
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        list.add(n1);
	        list.add(n2);
	        list.add(n3);
	        
	        for(int i=0 ; i<3; i++){
	            int dupCount=Collections.frequency(list,list.get(i));
	            if(dupCount==3){
	                System.out.println(10000+(list.get(i)*1000));
	                break;
	            }
	            else if(dupCount==2){
	                System.out.println(1000+(list.get(i)*100));
	                break;
	            }
	            if(i==2) System.out.println(Collections.max(list)*100);
	        
	        }
    }
}