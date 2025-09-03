import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        
        while(input != null && !input.equals("")){
            int N = Integer.parseInt(input);
            
            int total = 0;
            int[][] coins = new int[N + 1][2];
            
            for(int i = 1; i <= N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
              
                int coin = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                
                coins[i][0] = coin;
                coins[i][1] = cnt;
                
                total += coin * cnt;
            }
            
            if(total % 2 > 0){
                sb.append("0\n");
                input = br.readLine();
                continue;
            }
            
            boolean[][] dp = new boolean[N + 1][total + 1];
            dp[0][0] = true;
            
            for(int i = 1; i <= N; i++){
                int coin = coins[i][0];
                int cnt = coins[i][1];
                
                for(int j = 0; j <= total; j++){
                    if(dp[i - 1][j]){
                        for(int k = 0; k <= coin * cnt; k += coin){
                            dp[i][j + k] = true;
                        }
                    }
                }    
            }
            
            if(dp[N][total / 2]) sb.append("1\n");
            else sb.append("0\n");
            
            input = br.readLine();
        }
        
        System.out.println(sb.toString());
    }
}