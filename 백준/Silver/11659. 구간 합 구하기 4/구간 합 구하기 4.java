import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int numCount = Integer.parseInt(st.nextToken());
        int repeatCount = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] sumArr = new int[numCount + 1];
        
        for(int i = 1; i < numCount + 1; i++){
            int num = Integer.parseInt(st.nextToken());
            sumArr[i] = sumArr[i - 1] + num;
        }
        
        for(int i = 0; i < repeatCount; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            System.out.println(sumArr[end] - sumArr[start -1]);
        }
        
        br.close();
    }
}