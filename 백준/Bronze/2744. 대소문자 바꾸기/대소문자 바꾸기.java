import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String word = br.readLine();
        
        for(int i = 0; i < word.length(); i++){
            char letter = word.charAt(i);
            if(letter >= 97) letter -= 32;
            else letter += 32;
            
            sb.append(letter);
        }
        
        System.out.println(sb);
    }
}