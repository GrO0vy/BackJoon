import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++){
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) arr[stack.pop()] = arr[i];
            stack.push(i);
        }

        while(!stack.isEmpty()) arr[stack.pop()] = -1;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) sb.append(arr[i] + " ");

        System.out.println(sb);
    }
}
