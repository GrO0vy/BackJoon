import java.util.*;
import java.io.*;

public class Main{
    static int[] nums;
    static int max;
    static int min;

    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());

        int[] op = new int[4];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) op[i] = Integer.parseInt(st.nextToken());

        dfs(1, op[0], op[1], op[2], op[3], nums[0]);

        System.out.printf("%d\n%d",max, min);
    }

    static void dfs(int count, int plus, int minus, int mul, int div, int sum){
        if(count == N){
            max = Math.max(max, sum);
            min = Math.min(min, sum);

            return;
        }

        for(int i = 0; i < 4; i++){
            if(i == 0 && plus > 0){
                dfs(count + 1, plus - 1, minus, mul, div, sum + nums[count]);
            }
            else if(i == 1 && minus > 0){
                dfs(count + 1, plus, minus - 1, mul, div, sum - nums[count]);
            }
            else if(i == 2 && mul > 0){
                dfs(count + 1, plus, minus, mul - 1, div, sum * nums[count]);
            }
            else if(i == 3 && div > 0){
                dfs(count + 1, plus, minus, mul, div - 1, sum / nums[count]);
            }
        }
    }
}