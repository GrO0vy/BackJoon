import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Consulting[] consultings = new Consulting[N + 1];
        int[] dp = new int[N + 1];

        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            consultings[i] = new Consulting(day, cost);
        }

        for(int i = 1; i <= N; i++){
            if(i + consultings[i].day <= N + 1) {
                int maxDp = 0;
                for(int j = 1; j < i; j++) maxDp = Math.max(maxDp, dp[j]);
                dp[i + consultings[i].day - 1] = Math.max(dp[i + consultings[i].day - 1], maxDp + consultings[i].cost);
            }
        }

        int max = -1;
        for(int i = 1; i <= N; i++) max = Math.max(max, dp[i]);

        System.out.println(max);
    }

    public static class Consulting{
        public int day;
        public int cost;

        public Consulting(int day, int cost){
            this.day = day;
            this.cost = cost;
        }
    }
}