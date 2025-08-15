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

        int result = buildings[0] > 0 ? 1 : 0;

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n - 1; i++){
            if(buildings[i + 1] == 0){
                while(!stack.isEmpty()) stack.pop();
                continue;
            }

            if(buildings[i + 1] > buildings[i]){
                result++;
            }
            else {
                while (!stack.isEmpty() && stack.peek() > buildings[i + 1]) {
                    stack.pop();
                }

                if(stack.isEmpty() || stack.peek() != buildings[i + 1] && buildings[i + 1] > 0) {
                    result++;
                }
            }

            stack.push(buildings[i]);
        }

        System.out.println(result);
    }
}