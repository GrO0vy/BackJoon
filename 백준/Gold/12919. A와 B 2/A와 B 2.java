import java.util.*;
import java.io.*;

public class Main{
    static String S;
    static StringBuilder sb;
    static int result;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        String T = br.readLine();
        
        dfs(T);
        
        System.out.println(result);
    }
    
    static void dfs(String T){
        if(T.length() == S.length()){
            if(T.equals(S)) result = 1;
            
            return;
        }
        
        if(T.startsWith("B")){
            sb = new StringBuilder(T.substring(1));
            dfs(sb.reverse().toString());
        }
        
        if(T.endsWith("A")){
            dfs(T.substring(0, T.length() - 1));
        }
    }
}