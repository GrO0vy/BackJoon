import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < N; i++){
            String team = br.readLine();
            map.put(team, new ArrayList<>());

            int cntMember = Integer.parseInt(br.readLine());
            for(int j = 0; j < cntMember; j++) map.get(team).add(br.readLine());
            Collections.sort(map.get(team));
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++){
            String keyword = br.readLine();
            int quiz = Integer.parseInt(br.readLine());

            if(quiz == 0){
                for(String m: map.get(keyword)) sb.append(m + "\n");
            }
            else{
                for(String key : map.keySet()){
                    if(map.get(key).contains(keyword)){
                        sb.append(key + "\n");
                        break;
                    }
                }
            }
        }

        System.out.println(sb);
    }
}