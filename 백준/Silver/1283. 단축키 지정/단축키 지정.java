import java.io.*;
import java.util.*;

public class Main{
    static Set<String> registered;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        sb = new StringBuilder();
        registered = new HashSet<>();

        for(int i = 0; i < N; i++){
            String option = br.readLine();

            if(!registerFirstLetter(option)) registerOtherLetter(option);
        }

        System.out.println(sb.toString());
    }

    static boolean registerFirstLetter(String option){
        String[] words = option.split(" ");
        
        for(String word: words){
            String[] arr = word.split("");

            if(arr[0].matches("[a-zA-z]") && !registered.contains(arr[0])) {
                String highlight = word.replaceFirst(arr[0], String.format("[%s]", arr[0]));
                sb.append(option.replaceFirst(word, highlight) + "\n");

                registered.add(arr[0].toLowerCase());
                registered.add(arr[0].toUpperCase());

                return true;
            }
        }

        return false;
    }

    static void registerOtherLetter(String option){
        String[] words = option.split(" ");
        
        for(String word: words){
            String[] arr = word.split("");

            for(String s: arr){
                if(s.matches("[a-zA-z]") && !registered.contains(s)) {
                    String highlight = word.replaceFirst(s, String.format("[%s]", s));
                    sb.append(option.replaceFirst(word, highlight) + "\n");

                    registered.add(s.toUpperCase());
                    registered.add(s.toLowerCase());

                    return;
                }
            }
        }

        sb.append(option + "\n");
    }
}