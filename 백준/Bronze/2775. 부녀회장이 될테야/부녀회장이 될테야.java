import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][] apt = new int[15][15];
        
        for(int i=0; i<15; i++){
            apt[0][i] = i+1;
            apt[i][0] = 1;
        }
        
        for(int i=1; i<15; i++){
            for(int j=1; j<15; j++){
                apt[i][j] = apt[i][j-1] + apt[i-1][j]; 
            }
        }
        
        for(int i=0; i<T; i++){
            int k = sc.nextInt();
            int n = sc.nextInt();
            
            System.out.println(apt[k][n-1]);
        }
        
    }
}