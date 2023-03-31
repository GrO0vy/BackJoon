import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        int B = sc.nextInt();
        int result = 0;
        
        StringBuffer sb = new StringBuffer(N);
        N = sb.reverse().toString();
        
        for(int i=0; i<N.length(); i++){
            int n = N.charAt(i);
            if(n > 57) n = n - 55;
            else n = n - 48;
            result += n * Math.pow(B,i);
        }
        System.out.println(result);
        sc.close();
    }
}