import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        int[] len = new int[N + 1];
        int result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());

            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j]) {
                    len[i] = Math.max(len[j] + 1, len[i]);
                    result = Math.max(len[i], result);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result + "\n");

        Stack<Integer> stack = new Stack<>();
        for(int i = N; i >= 1; i--) {
            if(len[i] == result) {
                stack.push(arr[i]);
                result--;
            }
        }

        while(!stack.isEmpty()) sb.append(stack.pop() + " ");

        System.out.println(sb);
    }
}