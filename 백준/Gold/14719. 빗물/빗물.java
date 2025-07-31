import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] map = new int[W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) map[i] = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < W; i++) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && map[i] >= map[stack.peek()]) {
                    int mid = stack.pop();

                    if (!stack.isEmpty()) {
                        int left = stack.peek();
                        int height = Math.min(map[i], map[left]) - map[mid];
                        int width = i - left - 1;

                        result += height * width;
                    }
                }
            }

            stack.push(i);
        }

        System.out.println(result);
    }
}