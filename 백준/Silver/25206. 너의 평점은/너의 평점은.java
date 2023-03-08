import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double total_score =0;
        double total_grade=0;
        
        while(sc.hasNext()){
            sc.next();
            double score = sc.nextDouble();
            String grade = sc.next();
            sc.nextLine();
            
            if(grade.equals("P")) continue;
            else if(grade.equals("A+")) total_grade += score*4.5;
            else if(grade.equals("A0")) total_grade += score*4.0;
            else if(grade.equals("B+")) total_grade += score*3.5;
            else if(grade.equals("B0")) total_grade += score*3.0;
            else if(grade.equals("C+")) total_grade += score*2.5;
            else if(grade.equals("C0")) total_grade += score*2.0;
            else if(grade.equals("D+")) total_grade += score*1.5;
            else if(grade.equals("D0")) total_grade += score*1.0;
            
            total_score += score;
        }
        
        System.out.println(total_grade / total_score);
        sc.close();
    }
}