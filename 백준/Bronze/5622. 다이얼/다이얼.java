import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String number = sc.next();
        System.out.println(calTime(number));
    }
    
    static int calTime(String number){
        int total=0;
        
        for(int i=0; i<number.length(); i++){
            if((int)number.charAt(i)>=65 && (int)number.charAt(i)<=67) total+=3;
            if((int)number.charAt(i)>=68 && (int)number.charAt(i)<=70) total+=4;
            if((int)number.charAt(i)>=71 && (int)number.charAt(i)<=73) total+=5;
            if((int)number.charAt(i)>=74 && (int)number.charAt(i)<=76) total+=6;
            if((int)number.charAt(i)>=77 && (int)number.charAt(i)<=79) total+=7;
            if((int)number.charAt(i)>=80 && (int)number.charAt(i)<=83) total+=8;
            if((int)number.charAt(i)>=84 && (int)number.charAt(i)<=86) total+=9;
            if((int)number.charAt(i)>=87 && (int)number.charAt(i)<=90) total+=10;
            
        }
        return total;
    }
}