import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] balls = br.readLine().toCharArray();
        
        int cntRed = 0;
        int cntBlue = 0;
        
        for(int i = 0; i < N; i++){
            if(balls[i] == 'R') cntRed++;
            else cntBlue++;
        }
        
        int result = Integer.MAX_VALUE;
        
        result = Math.min(result, moveLeft('R', balls, cntRed));
        result = Math.min(result, moveLeft('B', balls, cntBlue));
        result = Math.min(result, moveRight('R', balls, cntRed));
        result = Math.min(result, moveRight('B', balls, cntBlue));
        
        System.out.println(result);
    }
    
    static int moveLeft(char ball, char[] balls, int cntBall){
        int cntFirstBall = 0;
        for(int i = 0; i < balls.length; i++){
            if(balls[i] == ball) cntFirstBall++;    
            else break;
        }
        
        return cntBall - cntFirstBall;
    }
    
    static int moveRight(char ball, char[] balls, int cntBall){
        int cntLastBall = 0;
        for(int i = balls.length - 1; i >= 0; i--){
            if(balls[i] == ball) cntLastBall++;
            else break;
        }
        
        return cntBall - cntLastBall;
    }
}