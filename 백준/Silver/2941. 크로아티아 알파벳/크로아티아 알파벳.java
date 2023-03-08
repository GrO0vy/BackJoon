import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        s = s.replace("c=","k");
        s = s.replace("c-","k");
        s = s.replace("dz=","k");
        s = s.replace("d-","k");
        s = s.replace("lj","k");
        s = s.replace("nj","k");
        s = s.replace("s=","k");
        s = s.replace("z=","k");
        
        System.out.println(s.length());
    }
}