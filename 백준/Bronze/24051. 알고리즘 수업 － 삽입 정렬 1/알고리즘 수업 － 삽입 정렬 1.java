import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) 
            a[i] = Integer.parseInt(st.nextToken());
        
        int count = 0;
        
        for(int i = 1; i < n; i++) {
            int j = i;  // before를 i로 초기화
            int t = a[i];
            
            while(j > 0 && a[j-1] > t) {
                a[j] = a[j-1];
                j--;
                count++;
            
                if(count == k){
                    System.out.println(a[j]);
                    return;
                }
            }
            if(j != i) {
                a[j] = t;
                count++;
                
                if(count == k){
                    System.out.println(a[j]);
                    return;
                }
            }
        }
        if(count < k) System.out.println(-1);
        
        br.close();
    }
}