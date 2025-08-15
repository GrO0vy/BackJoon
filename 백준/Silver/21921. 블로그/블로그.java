import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] visit = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) visit[i] = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = 0;
        int total = 0;
        int max = -1;
        int count = 0;

        while(left <= right && right < N){
            if(right < X){
                total += visit[right++];
                max = total;
                count = 1;
                continue;
            }

            total -= visit[left++];
            total += visit[right++];

            if(total > max){
                max = total;
                count = 1;
            }
            else if(total == max){
                count++;
            }
        }

        if(max == 0) System.out.println("SAD");
        else{
            System.out.println(max);
            System.out.println(count);
        }
    }
}