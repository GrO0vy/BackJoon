import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(reader.readLine());
        
        int coinKinds = Integer.parseInt(info.nextToken());
        int targetAmounts = Integer.parseInt(info.nextToken());
        
        int[] coinAmounts = new int[coinKinds];
        
        for(int i = 0; i < coinKinds; i++){
            coinAmounts[coinKinds - i - 1] = Integer.parseInt(reader.readLine());
        }
        
        int coinUsed = 0;
        
        for(int i = 0; i < coinKinds; i++){
            coinUsed += targetAmounts / coinAmounts[i];
            targetAmounts %= coinAmounts[i];
        }
        
        System.out.println(coinUsed);
    }
}