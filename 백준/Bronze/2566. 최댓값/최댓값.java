import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int max =-1;
        int col=0;
        int row=0;
        
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                int num = sc.nextInt();
                if(num > max){
                    col = i+1;
                    row = j+1;
                    max = num;
                } 
            }
        }
        System.out.println(max);
        System.out.printf("%d %d",col,row);
        sc.close();
    }
}