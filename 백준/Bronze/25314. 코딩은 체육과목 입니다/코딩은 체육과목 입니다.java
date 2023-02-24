import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int memory = sc.nextInt();
        int count = memory/4;
        String dataType= "long";
        for(int i=0; i<count-1; i++){
            dataType+=" long";
        }
        System.out.printf("%s int",dataType);
    }
}