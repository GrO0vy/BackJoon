import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int idx = 1;

        while(true){
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            if(L == 0 && P == 0 && V == 0) break;

            System.out.printf("Case %d: %d\n", idx++, V / P * L + (int)Math.min(V % P, L));

            st = new StringTokenizer(br.readLine());
        }
    }
}