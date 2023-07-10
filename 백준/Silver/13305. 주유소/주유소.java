import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long cityCount = Long.parseLong(reader.readLine());
        StringTokenizer disInfo = new StringTokenizer(reader.readLine());
        long[] distance = new long[(int)(cityCount - 1)];
        
        for(int i = 0; i < cityCount - 1; i++){
            distance[i] = Long.parseLong(disInfo.nextToken());
        }
        
        StringTokenizer oilInfo = new StringTokenizer(reader.readLine());
        long[] oilCharge = new long[(int)cityCount];
        
        for(int i = 0; i < cityCount; i++){
            oilCharge[i] = Long.parseLong(oilInfo.nextToken());
        }
        
        long MinCharge = Integer.MAX_VALUE;
        long needToGo = 0;
        long totalPrice = 0;
        
        for(int i = 0; i < cityCount -1; i++){
            if(oilCharge[i] < MinCharge){
                totalPrice += needToGo * MinCharge;
                MinCharge = oilCharge[i];
                needToGo = 0;
            }
            needToGo += distance[i];
        }
        totalPrice += needToGo * MinCharge;
        
        System.out.println(totalPrice);
    }
}