import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] exp1 = new int[3];
        for(int i = 0; i < 3; i++) exp1[i] = Integer.parseInt(st.nextToken());

        int[] exp2 = new int[3];
        for(int i = 0; i < 3; i++) exp2[i] = Integer.parseInt(st.nextToken());

        for(int i = -999; i <=999; i++){
            for(int j = -999; j <= 999; j++){
                int result1 = exp1[0] * i + exp1[1] * j;
                int result2 = exp2[0] * i + exp2[1] * j;

                if(result1 == exp1[2] && result2 == exp2[2]){
                    System.out.printf("%d %d",i, j);
                    break;
                }
            }
        }
    }
}