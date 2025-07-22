import java.util.*;
import java.io.*;

public class Main{
    static int end;
    static StringBuilder sb;
    static char[] op = new char[]{' ', '+', '-'};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            end = Integer.parseInt(br.readLine());

            List<Integer> list = new ArrayList<>();
            list.add(1);

            dfs(2, "1", list);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int num, String exp, List<Integer> nums){
        if(num > end){
            int sum = 0;
            for(int n: nums) sum += n;

            if(sum == 0) sb.append(exp).append("\n");

            return;
        }

        for(char o: op){
            if(o == ' ') {
                int prev = nums.get(nums.size() - 1);

                if(prev > 0) nums.set(nums.size() - 1, prev * 10 + num);
                else nums.set(nums.size() - 1, prev * 10 - num);
                
                dfs(num + 1, exp + o + num, nums);
                nums.set(nums.size() - 1, prev);
            }
            else if(o == '+'){
                nums.add(num);
                dfs(num + 1,exp + o + num, nums);
                nums.remove(nums.size() - 1);
            }
            else{
                nums.add(num * -1);
                dfs(num + 1, exp + o + num, nums);
                nums.remove(nums.size() - 1);
            }
        }
    }
}