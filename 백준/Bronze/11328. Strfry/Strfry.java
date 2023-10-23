import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] s1 = st.nextToken().toCharArray();
            char[] s2 = st.nextToken().toCharArray();
            
            boolean isPossible = true;
            
            if(s1.length != s2.length){
                isPossible = false;
            }
            else{
                Arrays.sort(s1);
                Arrays.sort(s2);
            
                for(int j = 0; j < s1.length; j++){
                    if(s1[j] != s2[j]) {
                        isPossible = false;
                        break;
                    }
                }
            }
            
            if(isPossible) System.out.println("Possible");
            else System.out.println("Impossible");
        }
        
        br.close();
    }
}