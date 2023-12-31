import java.util.*;
import java.io.*;

public class Main{
   public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<String> words = new ArrayList<>();

        for(int i = 0; i < N; i++){
            String word = br.readLine();
            if(words.contains(word)) continue;

            int idx = words.size();
            for(int j = words.size() - 1; j >= 0; j--){
                if(words.get(j).length() > word.length()){
                    idx = j;
                }
                else if(words.get(j).length() == word.length()){
                    if(words.get(j).compareTo(word) > 0){
                        idx = j;
                    }
                }
                else break;
            }

            if(idx == words.size()) words.add(word);
            else words.add(idx, word);
        }

        for(int i = 0; i < words.size(); i++){
            System.out.println(words.get(i));
        }
    }
}