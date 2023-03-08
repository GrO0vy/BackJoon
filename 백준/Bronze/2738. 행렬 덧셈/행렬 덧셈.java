import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int col = sc.nextInt();
        int row = sc.nextInt();
        
        int[][] m1 = new int[col][row]; 
        int[][] m2 = new int[col][row];
        
        for(int i=0; i<col; i++){
            for(int j=0; j<row; j++){
                m1[i][j] = sc.nextInt();
            }
        }
        
        for(int i=0; i<col; i++){
            for(int j=0; j<row; j++){
                m2[i][j] = sc.nextInt();
            }
        }
        
        for(int i=0; i<col; i++){
            for(int j=0; j<row; j++){
                System.out.printf("%d ",m1[i][j]+m2[i][j]);
            }
            System.out.println();
        }
        sc.close();
    }
}