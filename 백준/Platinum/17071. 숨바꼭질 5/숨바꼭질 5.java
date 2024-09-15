import java.util.*;
import java.io.*;

public class Main{
    static final int MAX = 500001;
    static int[] deltas = {-1, 1, 2};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[][] visited = new boolean[MAX][2]; // [어디좌표에][몇초]

        int result = -1;

        if(N == K){
            System.out.println(0);
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        visited[N][0] = true;

        int time = 0;
        while(!queue.isEmpty()){
            K += ++time;

            if(K >= MAX) break;

            int size = queue.size();
            int flag = time % 2;

            for(int i = 0; i < size; i++){
                int cur = queue.poll();

                for(int j = 0; j < 3; j++){
                    int next = cur;

                    if(j < 2) next += deltas[j];
                    else next *= deltas[j];

                    if(inRange(next) && !visited[next][flag]){
                        queue.offer(next);
                        visited[next][flag] = true;
                    }
                }
            }

            if(visited[K][flag]){
                result = time;
                break;
            }
        }

        System.out.println(result);
    }

    static boolean inRange(int next){
        return -1 < next && next < MAX;
    }
}