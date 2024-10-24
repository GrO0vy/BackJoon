import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> sentences = new ArrayList<>();

        String input = br.readLine();
        while(true){
            sentences.add(input);

            if(input.endsWith("E-N-D")){
                break;
            }

            input = br.readLine();
        }

        String origin = "";
        for(String sentence: sentences) {
            origin += sentence;
        }

        origin = origin.replaceAll("[^a-zA-z-]", " ").replaceAll("\\s+", " ");

        String[] words = origin.split(" ");

        int maxLen = 0;
        String result = "";

        for(String word: words){
            if(word.length() > maxLen) {
                maxLen = word.length();
                result = word;
            }
        }

        System.out.println(result.toLowerCase());
    }
}