import java.io.*;
import java.util.*;

public class Main{
    static int[] nums = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());

            String max = max(n);
            String min = min(n);

            System.out.printf("%s %s\n", min, max);
        }
    }

    static String min(int cnt){
        String[] dp = new String[101];

        Arrays.fill(dp, "1".repeat(51));
        dp[2] = "1";
        dp[3] = "7";
        dp[4] = "4";
        dp[5] = "2";
        dp[6] = "6";
        dp[7] = "8";
        dp[8] = "10";

        String[] add = {"1", "7", "4", "2", "0", "8"};

        for(int i = 9; i <= cnt; i++){
            for(int j = 2; j <= 7; j++){
                String num = dp[i - j] + add[j - 2];
                dp[i] = smaller(dp[i], num);
            }
        }

        return dp[cnt];
    }

    static String smaller(String n1, String n2){
        if(n1.length() == n2.length()) return n1.compareTo(n2) <= 0 ? n1 : n2;

        return n1.length() <= n2.length() ? n1 : n2;
    }

    static String max(int cnt){
        String result = "";

        int cntOne = cnt / nums[1];
        int cntSeven = cnt % nums[1];

        if(cntSeven == 1) result += "7";
        else result += "1";

        for(int i = 0; i < cntOne - 1; i++){
            result += "1";
        }

        return result;
    }
}