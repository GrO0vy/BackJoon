import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
    
        for(int i=1; i<count+1; i++){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            System.out.printf("Case #%d: %d\n",i,(n1+n2));
        }
    }
}