import java.util.*;
import java.io.*;

public class Main{
   public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<String> words = new ArrayList<>();

        for(int i = 0; i < N; i++){
            String word = br.readLine();
            if(!words.contains(word)) words.add(word);
        }

        Comparator<String> comparator = new Comparator<String>(){
            public int compare(String o1, String o2){
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
                else return o1.length() - o2.length();
            }
        };

        Collections.sort(words, comparator);

        for(int i = 0; i < words.size(); i++){
            System.out.println(words.get(i));
        }
    }
}