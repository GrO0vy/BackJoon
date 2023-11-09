import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder[] sbs = new StringBuilder[201];
        for (int i=0; i<sbs.length; i++) {
            sbs[i] = new StringBuilder();
        }

        StringTokenizer st;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            sbs[age].append(age).append(" ").append(name).append('\n');
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder s : sbs) {
            sb.append(s);
        }
        System.out.println(sb);
    }
}