import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        st= new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < n; i++)
            set1.add(Integer.parseInt(st.nextToken()));


        st= new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < m; i++)
            set2.add(Integer.parseInt(st.nextToken()));


        if(set1.isEmpty())
            System.out.println(0);
        else {
            set1.removeAll(set2);
            System.out.println(set1.size());

            List<Integer> list = new ArrayList<>(set1);
            Collections.sort(list);
            for (int i : list)
                System.out.print(i + " ");
        }
    }
}