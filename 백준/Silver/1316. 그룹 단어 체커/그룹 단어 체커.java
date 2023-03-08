import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int result = 0;
        sc.nextLine();
        
        for(int i=0; i<count; i++){    
            String s = sc.nextLine();
            ArrayList<String> letters = new ArrayList<String>();
            boolean yn =true;
       
            for(int j=0; j<s.length(); j++){
                letters.add(String.valueOf(s.charAt(j)));
            }
            while(true){
            	if(letters.size()<2) {
            		break;
            	}
                String s1 = letters.get(0);
                String s2 = letters.get(1);
                
                if(s1.equals(s2)) letters.remove(1);
                else{
                    letters.remove(0);
                    if(Collections.frequency(letters,s1) > 0){
                        yn = false;
                        break;
                    }
                }   
            }
            if(yn) result+=1;
        }
        System.out.println(result);
    }
}    