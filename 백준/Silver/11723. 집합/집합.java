import java.io.*;
import java.util.*;

public class Main{
    static boolean[] set;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        
        set = new boolean[21];
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            String operation = st.nextToken();
            
            if(operation.equals("all")) all();
            else if(operation.equals("empty")) empty();
            else{
                int x = Integer.parseInt(st.nextToken());
                
                if(operation.equals("add")) add(x);
                else if(operation.equals("remove")) remove(x);
                else if(operation.equals("check")) sb.append(check(x) + "\n");
                else toggle(x);
            }
        }
        
        System.out.println(sb.toString());
    }
    
    static void all(){
        for(int i = 1; i <= 20; i++) set[i] = true;
    }
    
    static void empty(){
        for(int i = 1; i <= 20; i++) set[i] = false;
    }
    
    static void add(int x){
        set[x] = true;
    }
    
    static void remove(int x){
        set[x] = false;
    }
    
    static int check(int x){
        return set[x] ? 1 : 0;
    }
    
    static void toggle(int x){
        set[x] = !set[x];
    }
}