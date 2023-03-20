import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int PosX =0;
        int PosY =0;
        
        ArrayList<Integer> xList = new ArrayList<Integer>();
        ArrayList<Integer> yList = new ArrayList<Integer>();
        
        for(int i=0; i<3; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            
            xList.add(x1);
            yList.add(y1);
        }
        
        for(int x : xList){
            if(Collections.frequency(xList,x) == 1) PosX = x;
        }
        for(int y : yList){
            if(Collections.frequency(yList,y) == 1) PosY =y;
        }
        
        System.out.printf("%d %d",PosX,PosY);
        sc.close();
    }
}