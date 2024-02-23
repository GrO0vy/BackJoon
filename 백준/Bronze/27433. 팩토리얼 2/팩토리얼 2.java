import java.util.Scanner;

public class Main{
    static long N;
    static long result;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextLong();
        
        result = 1;
        solution(1);
        
        System.out.println(result);
    }
    
    static void solution(int cnt){
        if(cnt > N) return;
        result *= cnt;
        solution(cnt + 1);
    }
}