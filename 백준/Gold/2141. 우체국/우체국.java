import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] info = new int[N][2];
        long total = 0;
        StringTokenizer st;  
      
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
            total += info[i][1];
        }
        
        Arrays.sort(info, new Comparator<>(){
            public int compare(int[] o1, int[] o2){
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                else return o1[0] - o2[0];
            }
        });
        
        long mid = (total + 1) / 2;
        long people = 0;
        int result = 0;
        
        for(int i = 0; i < N; i++){
            people += info[i][1];
            
            if(people >= mid){
                result = info[i][0];
                break;
            }
        }
        
        System.out.println(result);
    }
}