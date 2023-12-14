import java.util.*;
import java.io.*;

public class Main{
    static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[][] edgeList = new int[E][3];
        parent = new int[V + 1];

        for(int i = 1; i <= V; i++) parent[i] = i;

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edgeList[i] = new int[]{start, end, weight};
        }

        Arrays.sort(edgeList, (o1, o2) ->{
            return o1[2] - o2[2];
        });

        int result = 0;

        for(int[] edge: edgeList){
            int start = edge[0];
            int end = edge[1];
            int weight = edge[2];

            if(find(start) != find(end)) {
                union(start, end);
                result += weight;
            }
        }

        System.out.print(result);
    }

    static int find(int num){
        if(parent[num] != num) return parent[num] = find(parent[num]);
        else return num;
    }

    static void union(int a, int b){
        int parentA = find(a);
        int parentB = find(b);

        if(parentA != parentB) parent[parentB] = parentA;
    }
}