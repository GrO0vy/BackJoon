import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> scores = new ArrayList<Integer>();
        ArrayList<Double> result = new ArrayList<Double>();
        
        for(int i=0; i<N; i++){
            int score = sc.nextInt();
            scores.add(score);
        }
        int max = Collections.max(scores);
        
        for(double score : scores) {
        	double update = (double)score/(double)max*100;
        	result.add(update);
        }
        double total =0;
        for(double score : result) {
        	total += score;
        }
        double avg = total/N;
        System.out.println(avg);
        sc.close();
    }
}