import java.util.Scanner;
import java.util.Collections;

public class Main{
    public static void main(String[] args){
           Scanner sc = new Scanner(System.in);
	        String s = sc.nextLine();
	        int count =0;
	        
	        s = s.trim();
	        
	        if(s.replace(" ","").length() == 0) System.out.println(0);
	        else {
	        	for(int i=0; i<s.length(); i++) {
		        	if(String.valueOf(s.charAt(i)).equals(" ")) {
		        		count= count+1;
		        	}
		        }
		        System.out.println(count+1);
	        }
    }
}