import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[][] space = new int[100][100];
        int N = sc.nextInt();
        int result = 0;
        
        for(int i=0; i<N; i++){
            int width = sc.nextInt();
            int height = sc.nextInt();
            
            for(int j=width; j<width+10; j++){
                for(int k=99-height; k>89-height; k--){
                    space[j][k] = 1;
                }
            }
        }
        
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(space[i][j] == 1) result+=1;
            }
        }
        
        System.out.println(result);
        
    }
}