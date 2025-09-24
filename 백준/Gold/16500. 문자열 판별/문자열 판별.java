import java.util.*;
import java.io.*;

public class Main{
    static String[] words;
    static String S;
    static int result;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        
        int N = Integer.parseInt(br.readLine());

        words = new String[N];
        for(int i = 0; i < N; i++){
            words[i] = br.readLine();    
        }
        
        System.out.println(canPossible());
    }
    
    static int canPossible(){
        Queue<String> queue = new LinkedList<>();
        queue.offer("");
        Set<String> visited = new HashSet<>();
        
        while(!queue.isEmpty()){
            String str = queue.poll();
            
            for(String word: words){
                String next = str + word;
                
                if(S.equals(next)) return 1;
                
                if(!visited.contains(next) && S.startsWith(next)){
                    visited.add(next);
                    queue.offer(next);    
                }
            }
        }
        
        return 0;
    }
}