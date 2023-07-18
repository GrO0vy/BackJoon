import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        
        Stack<Character> characters = new Stack<>();
        StringBuilder answer = new StringBuilder();
        
        for(int i = 0; i < count; i++){
            String sentence = reader.readLine();
            for(int j = 0; j < sentence.length(); j++){
                char token = sentence.charAt(j);
                if(token == ' '){
                    while(!characters.isEmpty()){
                        answer.append(characters.pop());
                    }
                    answer.append(token);
                }
                else{
                    characters.push(token);    
                }
            }
            while(!characters.isEmpty()){
                answer.append(characters.pop());
            }
            answer.append("\n");
        }
        
        System.out.println(answer);
    }
}