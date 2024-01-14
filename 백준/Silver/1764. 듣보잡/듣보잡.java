import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        HashMap<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        
        for(int i = 0; i < N + M; i++){
            String person = br.readLine();
            map.put(person, map.getOrDefault(person, 0) + 1);
        }
        
        int cnt = 0;
        for(String key: map.keySet()){
            if(map.get(key) == 2) {
                list.add(key);
                cnt++;
            }
        }
        
        Collections.sort(list);
        
        StringBuilder sb = new StringBuilder();
        for(String name: list) sb.append(name + "\n"); 
        
        System.out.println(cnt);
        System.out.println(sb);
    }
}