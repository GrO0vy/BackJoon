import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String problem = br.readLine();

        int red = 0;
        int blue = 0;
        char c = problem.charAt(0);

        for(int i = 0; i < N; i++){
            if(problem.charAt(i) != c){
                if(c == 'R') red++;
                else blue++;

                c = problem.charAt(i);
            }
        }

        System.out.println(Math.max(red, blue) + 1);
    }
}