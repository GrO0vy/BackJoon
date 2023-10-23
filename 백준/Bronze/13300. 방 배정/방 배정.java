import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[][] students = new int[6][2];
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());
            
            students[grade - 1][gender]++;
        }
        
        int rooms = 0;
        
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 2; j++){
                rooms += students[i][j] / K;
                if(students[i][j] % K > 0) rooms++;
            }
        }
        
        System.out.println(rooms);
        
        br.close();
    }
}