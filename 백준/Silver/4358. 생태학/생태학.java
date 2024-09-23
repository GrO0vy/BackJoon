import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        int cnt = 0;

        while(input != null && !input.equals("")){
            map.put(input, map.getOrDefault(input, 0) + 1);
            set.add(input);
            cnt++;

            input = br.readLine();
        }

        if(cnt == 0){
            System.out.println();
            return;
        }

        List<String> list = new ArrayList<>(set);

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for(String key : list){
            double percent = map.get(key) / (double)cnt * 100;
            sb.append(key + String.format(" %.4f\n", percent));
        }

        System.out.println(sb);
    }
}