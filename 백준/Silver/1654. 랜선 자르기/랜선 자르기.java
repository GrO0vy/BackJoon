import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        long N = Long.parseLong(st.nextToken());

        long[] LAN = new long[K];

        for(int i = 0; i < K; i++){
            LAN[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(LAN);

        System.out.println(binarySearch(LAN, N));
    }

    static long binarySearch(long[] LAN, long N){
        long start = 0;
        long end = LAN[LAN.length - 1] * 2;
        long mid;
        long max = Long.MIN_VALUE;

        while(start < end){
            mid = (start + end) / 2;

            long cnt = 0;

            for(int i = 0; i < LAN.length; i++){
                cnt += LAN[i] / mid;
            }

            if(cnt >= N) {
                max = Math.max(max, mid);
                start = mid + 1;
            }

            else end = mid;
        }

        return max;
    }
}