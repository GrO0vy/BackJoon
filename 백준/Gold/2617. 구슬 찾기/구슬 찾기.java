import java.util.*;
import java.io.*;

public class Main{
    public static int MIDDLE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        MIDDLE = (N + 1) / 2;

        List<List<Integer>> cntHeavy = new ArrayList<>();
        List<List<Integer>> cntLight = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            cntHeavy.add(new ArrayList<>());
            cntLight.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int heavy = Integer.parseInt(st.nextToken());
            int light = Integer.parseInt(st.nextToken());

            cntHeavy.get(light).add(heavy);
            cntLight.get(heavy).add(light);
        }

        int cnt = 0;

        for(int i = 1; i <= N; i++){
            if(count(cntHeavy, i, new boolean[N + 1]) >= MIDDLE || count(cntLight, i, new boolean[N + 1]) >= MIDDLE) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static int count(List<List<Integer>> balls, int ball, boolean[] visited){
        int cnt = 0;
        List<Integer> current = balls.get(ball);
        for(int i = 0; i < current.size(); i++){
            int next = current.get(i);

            if(!visited[next]) {
                visited[next] = true;
                cnt++;
                cnt += count(balls, next, visited);
            }
        }

        return cnt;
    }
}