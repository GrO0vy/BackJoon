import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] bus = new int[M][3];
        boolean hasCycle = false;

        long[] minDistance = new long[N + 1];
        for (int i = 2; i < N + 1; i++) {
            minDistance[i] = Integer.MAX_VALUE;
        }
        minDistance[1] = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            bus[i][0] = Integer.parseInt(st.nextToken());
            bus[i][1] = Integer.parseInt(st.nextToken());
            bus[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M - 1; i++) {
            for (int[] way : bus) {
                int start = way[0];
                int end = way[1];
                int weight = way[2];

                if (!(minDistance[start] == Integer.MAX_VALUE) &&
                        minDistance[start] + weight < minDistance[end]) {
                    minDistance[end] = minDistance[start] + weight;
                }
            }
        }

        for (int[] way : bus) {
            int start = way[0];
            int end = way[1];
            int weight = way[2];

            if (!(minDistance[start] == Integer.MAX_VALUE) &&
                    minDistance[start] + weight < minDistance[end]) {
                hasCycle = true;
                break;
            }
        }

        if (hasCycle) System.out.println(-1);
        else {
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i <= N; i++) {
                if (minDistance[i] == Integer.MAX_VALUE) sb.append(-1).append("\n");
                else sb.append(minDistance[i]).append("\n");
            }
            
            System.out.println(sb);
        }
    }
}