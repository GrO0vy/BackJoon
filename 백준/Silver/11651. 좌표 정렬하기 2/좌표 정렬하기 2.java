import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] pos = new int[N][2];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            pos[i][0] = x;
            pos[i][1] = y;
        }

        Arrays.sort(pos, (o1, o2) -> {
                if(o1[1] == o2[1]) return o1[0] - o2[0];
                else return o1[1] - o2[1];
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) sb.append(pos[i][0] + " " + pos[i][1] + "\n");

        System.out.println(sb);
    }
}