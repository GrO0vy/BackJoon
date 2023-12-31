import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] origin = new int[N];
        int[] sorted = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            origin[i] = Integer.parseInt(st.nextToken());
            sorted[i] = origin[i];
        }

        Arrays.sort(sorted);

        HashMap<Integer, Integer> ranks = new HashMap<>();
        int rank = 0;
        for(int i = 0; i < N; i++){
            if(!ranks.containsKey(sorted[i])) ranks.put(sorted[i], rank++);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(ranks.get(origin[i]) + " ");
        }

        System.out.println(sb);
    }
}