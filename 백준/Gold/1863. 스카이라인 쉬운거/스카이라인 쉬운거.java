import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] buildings = new int[n];

        for(int i = 0; i < n; i++){
            String[] input = br.readLine().split(" ");

            buildings[i] = Integer.parseInt(input[1]);
        }

        int result = 0;

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            if(buildings[i] == 0){
                while(!stack.isEmpty()) stack.pop();
                continue;
            }

            while(!stack.isEmpty() && stack.peek() > buildings[i]) stack.pop();

            if(stack.isEmpty() || stack.peek() != buildings[i]){
                stack.push(buildings[i]);
                result++;
            }
        }

        System.out.println(result);
    }
}