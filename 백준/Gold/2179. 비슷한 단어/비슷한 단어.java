import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, String> map = new HashMap<>();
        Map<String, Integer> idxMap = new HashMap<>();
        
        int correct = 0;
        String S = "";
        String T = "";

        for(int i = 0; i < N; i++){
            String word = br.readLine();
            if(!idxMap.containsKey(word)) idxMap.put(word, i);
            
            for(int j = 1; j <= word.length(); j++){
                String substr = word.substring(0, j);

                if(map.containsKey(substr)){
                    if(word.equals(map.get(substr))) continue;

                    if(correct < substr.length()){
                        S = map.get(substr);
                        T = word;
                        correct = substr.length();
                    }
                    else if(correct == substr.length()){
                        if(idxMap.get(map.get(substr))< idxMap.get(S)){
                            S = map.get(substr);
                            T = word;
                        }
                        else if(idxMap.get(word) < idxMap.get(T)){
                            S = map.get(substr);
                            T = word;   
                        }
                    }
                }
                else{
                    map.put(substr, word);
                }
            }
        }

        System.out.println(S);
        System.out.println(T);
    }
}