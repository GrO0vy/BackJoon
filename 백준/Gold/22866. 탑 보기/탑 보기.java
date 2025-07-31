import java.util.*;
import java.io.*;

public class Main{
    static int[] buildings;
    static int[] near;
    static int[] cntCanSee;
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        buildings = new int[N];
        cntCanSee = new int[N];
        near = new int[N];

        Arrays.fill(near, -1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        findLeft();
        findRight();

        for(int i = 0; i < N; i++){
            if(cntCanSee[i] == 0) System.out.println(0);
            else System.out.printf("%d %d\n", cntCanSee[i], near[i] + 1);
        }
    }

    static void findLeft(){
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++){
            while(!stack.isEmpty() && buildings[stack.peek()] <= buildings[i]){
                stack.pop();
            }

            if(!stack.isEmpty()){
                near[i] = stack.peek();
                cntCanSee[i] += stack.size();
            }

            stack.push(i);
        }
    }

    static void findRight(){
        Stack<Integer> stack = new Stack<>();
        for(int i = N - 1; i >= 0; i--){
            while(!stack.isEmpty() && buildings[stack.peek()] <= buildings[i]){
                stack.pop();
            }

            if(!stack.isEmpty()){
                if(near[i] == -1 || i - near[i] > stack.peek() - i) near[i] = stack.peek();
                cntCanSee[i] += stack.size();
            }

            stack.push(i);
        }
    }
}