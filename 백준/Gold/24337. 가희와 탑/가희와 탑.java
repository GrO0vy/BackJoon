import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int left = Integer.parseInt(st.nextToken());
        int right = Integer.parseInt(st.nextToken());

        List<Integer> buildings = new ArrayList<>();
        buildings.add(Math.max(left, right));

        N--;

        for(int i = 1; i < left; i++){
            buildings.add(buildings.size() - 1, i);
            N--;
        }

        for(int i = 1; i < right; i++){
            buildings.add(buildings.size() - i + 1, i);
            N--;
        }

        if(N < 0){
            System.out.println(-1);
            return;
        }

        if(buildings.get(0) == 1){
            for(int i = 0; i < N; i++){
                buildings.add(0, 1);
            }
        }
        else{
            for(int i = 0; i < N; i++){
                buildings.add(1, 1);
            }
        }

        // StringBuilder sb = new StringBuilder();
        // for(int i = 0; i < buildings.size(); i++){
        //     sb.append(buildings.get(i) + " ");
        // }

        for(int i = 0; i < buildings.size(); i++){
            System.out.print(buildings.get(i) + " ");
        }
    }
}