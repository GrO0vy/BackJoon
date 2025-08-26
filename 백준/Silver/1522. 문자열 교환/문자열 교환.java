import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int n = str.length();
        int window = 0;
        
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'a') window++;
        }
        
        int result = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            int cntB = 0;
            for(int j = i; j < i + window; j++){
                if(str.charAt(j % n) == 'b') cntB++;    
            }
            
            result = Math.min(result, cntB);
        }

        System.out.println(result);
    }
}