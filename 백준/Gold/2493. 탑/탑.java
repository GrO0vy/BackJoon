import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> tops = new Stack<>();
        Stack<Integer> temp = new Stack<>();

        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            tops.push(i);
        }

        while(!tops.isEmpty()){
            if(temp.isEmpty() || arr[tops.peek()] < arr[temp.peek()]) temp.push(tops.pop());
            else{
                int next = tops.pop();
                while(!temp.isEmpty() && arr[next] >= arr[temp.peek()]){
                    arr[temp.pop()] = next;
                }
                temp.push(next);
            }
        }

        while(!temp.isEmpty()) arr[temp.pop()] = 0;

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            sb.append(arr[i] + " ");
        }

        System.out.println(sb);
    }
}