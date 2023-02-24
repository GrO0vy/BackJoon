import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int j;
        int k;
        for(int i=count; i>0; i--){
            for(j=0; j<i-1; j++){
                System.out.print(" ");   
            }
            for(k=0; k<count-j; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}