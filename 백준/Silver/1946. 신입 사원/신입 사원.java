import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            int[][] rank = new int[N][2];

            StringTokenizer st;

            for(int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                rank[j][0] = Integer.parseInt(st.nextToken());
                rank[j][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(rank, new Comparator<>(){
                public int compare(int[] o1, int[] o2){
                    return o1[0] - o2[0];
                }
            });

            int cnt = 1;
            int max = rank[0][1];

            for(int j = 1; j < N; j++){
                if(rank[j][1] <= max){
                    max = rank[j][1];
                    cnt++;
                }
            }

            sb.append(cnt + "\n");
        }

        System.out.println(sb);
    }
}