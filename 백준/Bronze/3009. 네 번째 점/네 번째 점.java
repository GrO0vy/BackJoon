import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[][] Pos = new int[2][3];
        int PosX =0;
        int PosY =0;
        
        for(int i=0; i<3; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            
            Pos[0][i] =x1;
            Pos[1][i] =y1;
        }
        
        ArrayList<Integer> xList = new ArrayList<Integer>();
        ArrayList<Integer> yList = new ArrayList<Integer>();
        
        for(int x : Pos[0]) xList.add(x);
        for(int y : Pos[1]) yList.add(y);
        
        for(int i=0; i<3; i++){
            if(Collections.frequency(xList,Pos[0][i]) == 1) PosX = Pos[0][i];
            if(Collections.frequency(yList,Pos[1][i]) == 1) PosY = Pos[1][i];
        }
        
        System.out.printf("%d %d",PosX,PosY);
        sc.close();
    }
}