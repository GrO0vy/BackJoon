import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next().toUpperCase();
        String s2 = s;
        ArrayList<Integer> counts = new ArrayList<Integer>();
        
        while(s2 != ""){
            int count = s2.length()-s2.replace(String.valueOf(s2.charAt(0)),"").length();
            counts.add(count);
            s2 = s2.replace(String.valueOf(s2.charAt(0)),"");
        }
        
        int max = Collections.max(counts);
        
        if(Collections.frequency(counts,max) > 1){
            System.out.println("?");
        }
        else{
            for(int i=0; i<counts.indexOf(max); i++){
                s = s.replace(String.valueOf(s.charAt(0)),"");
            }
            System.out.println(s.charAt(0));
        }
        sc.close();
    }
}