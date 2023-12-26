import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int M;
    static int[] lectures;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lectures = new int[N];

        int start = 0;
        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            lectures[i] = Integer.parseInt(st.nextToken());
            sum += lectures[i];
            start = Math.max(start, lectures[i]);
        }

        System.out.println(binarySearch(start, sum));
    }

    static int binarySearch(int start, int end){
        while(start <= end){
            int mid = ( start + end ) / 2;
            int count = 1;
            int sum = 0;

            for(int i = 0; i < N; i++){
                sum += lectures[i];
                if(sum > mid){
                    count++;
                    sum = lectures[i];
                }
            }

            if(count <= M) end = mid - 1;
            else start = mid + 1;
        }

        return start;
    }
}