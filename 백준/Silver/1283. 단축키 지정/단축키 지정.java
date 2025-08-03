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

        int left = 0;

        for(String word: words){
            String[] arr = word.split("");

            if(arr[0].matches("[a-zA-z]") && !registered.contains(arr[0])) {
                String highlight = String.format("[%s]", arr[0]);
                option = option.substring(0, left) + highlight + option.substring(left + 1);

                sb.append(option + "\n");

                registered.add(arr[0].toLowerCase());
                registered.add(arr[0].toUpperCase());

                return true;
            }

            left += word.length() + 1;
        }

        return false;
    }

    static void registerOtherLetter(String option){
        String[] words = option.split(" ");

        int left = 0;

        for(String word: words){
            String[] arr = word.split("");

            for(String s: arr){
                if(s.matches("[a-zA-z]") && !registered.contains(s)) {
                    String highlight = String.format("[%s]", s);
                    option = option.substring(0, left) + highlight + option.substring(left + 1);

                    sb.append(option + "\n");

                    registered.add(s.toUpperCase());
                    registered.add(s.toLowerCase());

                    return;
                }

                left++;
            }

            left++;
        }

        sb.append(option + "\n");
    }
}