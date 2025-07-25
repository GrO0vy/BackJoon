import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] buildings = new int[N];
        int max = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) buildings[i] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            int cntSee = 0;

            double inclination = 0;

            for(int j = i - 1; j >= 0; j--){
                if(j == i - 1 || (double) (buildings[i] - buildings[j]) / (i - j) < inclination){
                    cntSee++;
                    inclination = (double) (buildings[i] - buildings[j]) / (i - j);
                }
            }

            for(int j = i + 1; j < N; j++){
                if(j == i + 1 || (double)(buildings[i] - buildings[j]) / (i - j)> inclination){
                    cntSee++;
                    inclination = (double) (buildings[i] - buildings[j]) / (i - j);
                }
            }

            max = Math.max(max, cntSee);
        }

        System.out.println(max);
    }
}