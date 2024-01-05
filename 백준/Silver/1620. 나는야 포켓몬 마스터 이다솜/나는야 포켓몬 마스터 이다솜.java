import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> dict1 = new HashMap<>();
        HashMap<Integer, String> dict2 = new HashMap<>();
        
        for(int i = 1; i <= N; i++){
            String monster = br.readLine();
            dict1.put(monster, i);
            dict2.put(i, monster);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            String problem = br.readLine();
            try{
                int number = Integer.parseInt(problem);
                sb.append(dict2.get(number) + "\n");
            }catch(Exception e){
                sb.append(dict1.get(problem) + "\n");
            }
        }
        
        System.out.println(sb);
    }
}