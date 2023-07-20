import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        StringTokenizer numberInfo = new StringTokenizer(reader.readLine());
        int[] maxArr = new int[count];
        
        maxArr[0] = Integer.parseInt(numberInfo.nextToken());
        
        for(int i = 1; i < count; i++){
            int number = Integer.parseInt(numberInfo.nextToken());
            if(number > maxArr[i - 1] + number) maxArr[i] = number;
            else maxArr[i] = maxArr[i - 1] + number;
        }
        
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < count; i++){
            if(maxArr[i] > max) max = maxArr[i];
        }
        
        System.out.println(max);
    }
}