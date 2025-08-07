import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++){
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            int min = 10001;
            int max = -1;

            Map<Character, List<Integer>> map = new HashMap<>();
            for(int j = 0; j < W.length(); j++){
                char letter = W.charAt(j);

                if(!map.containsKey(letter)) map.put(letter, new ArrayList<>());

                map.get(letter).add(j);
            }

            for(List<Integer> list: map.values()){
                for(int j = 0; j < list.size(); j++){
                    if(j >= K - 1){
                        int length = list.get(j) - list.get(j - (K - 1)) + 1;
                        min = Math.min(min, length);
                        max = Math.max(max, length);
                    }
                }
            }

            if(min == 10001) sb.append(-1 + "\n");
            else sb.append(min + " " + max + "\n");
        }

        System.out.println(sb.toString());
    }
}