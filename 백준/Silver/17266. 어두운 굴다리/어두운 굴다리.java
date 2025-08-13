import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Integer> bridge = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int height = 0;

        for(int i = 0; i < M; i++){
            int light = Integer.parseInt(st.nextToken());

            if(bridge.isEmpty()) height = Math.max(height, light);
            else{
                int requiredHeight = (light - bridge.get(i - 1)) / 2;

                if((light - bridge.get(i - 1)) % 2 > 0) requiredHeight++;

                height = Math.max(height, requiredHeight);
            }
            
            if(i == M - 1){
                height = Math.max(height, N - light);
            }

            bridge.add(light);
        }

        System.out.println(height);
    }
}