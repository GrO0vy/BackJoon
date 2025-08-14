import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> words = new HashMap<>();

        for(int i = 0; i < N; i++){
            String word = br.readLine();

            if(word.length() < M) continue;

            words.put(word, words.getOrDefault(word, 0) + 1);
        }

        List<Word> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry: words.entrySet()){
            list.add(new Word(entry.getKey(), entry.getValue()));
        }

        Collections.sort(list);
        
        StringBuilder sb = new StringBuilder();
        for(Word word: list){
            sb.append(word.str + "\n");
        }
        
        System.out.println(sb.toString());
    }

    static class Word implements Comparable<Word>{
        String str;
        int count;

        public Word(String str, int count){
            this.str = str;
            this.count = count;
        }

        public int compareTo(Word o){
            if(this.count != o.count) return o.count - this.count;
            if(this.str.length() != o.str.length()) return o.str.length() - this.str.length();

            return this.str.compareTo(o.str);
        }
    }
}