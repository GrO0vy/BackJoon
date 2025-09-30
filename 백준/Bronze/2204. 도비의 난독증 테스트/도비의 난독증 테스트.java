import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            String[] words = new String[n];
            for(int i = 0; i < n; i++) words[i] = br.readLine();
            
            Arrays.sort(words, (o1, o2) -> o1.toUpperCase().compareTo(o2.toUpperCase()));
            sb.append(words[0] + "\n");
            
            n = Integer.parseInt(br.readLine());
        }
        
        System.out.println(sb.toString());
    }
}