import java.util.*;
import java.io.*;

public class Main{
    static List<Integer> set;
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        set = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        arr = new int[N + 1];

        for(int i = 1; i <= N; i++) arr[i] = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(i, arr[i]);
            visited[i] = false;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(set.size() + "\n");

        for(int value: set) sb.append(value + "\n");

        System.out.println(sb.toString());
    }

    static void dfs(int target, int idx){
        if(target == idx) set.add(target);

        if(!visited[idx]){
            visited[idx] = true;
            dfs(target, arr[idx]);
            visited[idx] = false;
        }
    }
}