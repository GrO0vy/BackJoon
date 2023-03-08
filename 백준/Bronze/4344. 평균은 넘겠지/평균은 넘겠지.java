import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        
        for(int i=0; i<C; i++){
            ArrayList<Integer> scores = new ArrayList<Integer>();
            int total =0;
            double avg =0;
            int count = sc.nextInt();
            int overAvg = 0;
            for(int j=0; j<count; j++){
                int score=sc.nextInt();
                total+=score;
                scores.add(score);
            }
            avg = total/ count;
            
            for(int s : scores){
                if(s > avg){
                    overAvg++;
                }
            }
            System.out.println(String.format("%.3f",(double)overAvg/(double)count*100)+"%");
        }
    }
}