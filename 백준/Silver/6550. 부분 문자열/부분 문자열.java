import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        
        while(input != null && !input.equals("")){
            StringTokenizer st = new StringTokenizer(input);
            String s = st.nextToken();
            String t = st.nextToken();
            
            if(isSubstring(s, t)){
                sb.append("Yes\n");
            }
            else sb.append("No\n");

            input = br.readLine();
        }
        
        System.out.println(sb.toString());
    }
    
    static boolean isSubstring(String s, String t){
        if(s.length() > t.length()) return false;
        
        int idxS = 0;
        int idxT = 0;
        
        while(idxS < s.length() && idxT < t.length()){
            if(s.charAt(idxS) == t.charAt(idxT)){
                idxS++;
            }
            idxT++;
        }
        
        return idxS == s.length();
    }
}