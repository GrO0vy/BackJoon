import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] universes = new int[M][N];
        int[][] sorted = new int[M][N];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                universes[i][j] = Integer.parseInt(st.nextToken());
                sorted[i][j] = universes[i][j];
            }

            Arrays.sort(sorted[i]);
        }

        for(int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) universes[i][j] = Arrays.binarySearch(sorted[i], universes[i][j]);
        }

        int result = 0;
        for(int i = 0; i < M; i++){
            result += search(i, universes);
        }

        System.out.println(result);
    }

    static int search(int start, int[][] universes){
        int[] origin = universes[start];
        int cnt = 0;

        for(int i = start + 1; i < universes.length; i++){
            if(Arrays.equals(origin, universes[i])) cnt++;
        }

        return cnt;
    }

    static class Universe{
        int idx;
        int value;
        int priority;

        public Universe(int idx, int value){
            this.idx = idx;
            this.value = value;
        }
    }
}