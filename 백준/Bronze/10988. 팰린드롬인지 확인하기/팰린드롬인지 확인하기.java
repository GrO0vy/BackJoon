import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2="";
        ArrayList<String> letters = new ArrayList<String>();
        
        for(int i=0; i<s1.length(); i++){
            letters.add(String.valueOf(s1.charAt(i)));    
        }
        
        Collections.reverse(letters);
        
        for(String l : letters){
            s2+=l;
        }
        
        if(s1.equals(s2)) System.out.println(1);
        else System.out.println(0);
        
        sc.close();
    }
}