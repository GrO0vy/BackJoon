import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        
        int cntRequired = 0;
        
        if(game.equals("Y")) cntRequired = 1;
        else if(game.equals("F")) cntRequired = 2;
        else cntRequired = 3;
        
        Set<String> played = new HashSet<>();
        
        int result = 0;
        int cntPeople = 0;
        
        for(int i = 0; i < N; i++){
            String person = br.readLine();
            
            if(!played.contains(person)){
                played.add(person);
                cntPeople++;
            }
            
            if(cntPeople == cntRequired){
                result++;
                cntPeople = 0;
            }
        }
        
        System.out.println(result);
    }
}