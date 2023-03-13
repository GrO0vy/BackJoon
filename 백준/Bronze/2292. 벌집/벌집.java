import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int room = sc.nextInt();
        int result = 0;
        
        if(room == 1) result =1;
        else{
            for(int i=0; room>1; i++){
            room = room-(6*i);
            result +=1;
            }   
        }
        
        System.out.println(result);
    }
}