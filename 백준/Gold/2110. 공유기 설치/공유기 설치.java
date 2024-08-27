import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int C;
    static int[] arr;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        int low = 1;
        int high = arr[N - 1];

        while (low <= high) {
            int mid = (low + high) / 2;

            int cnt = 1;
            int pos = 0;
            for (int i = 1; i < N; i++) {
                if (arr[i] - arr[pos] >= mid) {
                    cnt++;
                    pos = i;
                }
            }

            if (cnt < C) high = mid - 1;
            else {
                result = Math.max(result, mid);
                low = mid + 1;
            }
        }

        System.out.println(result);
    }
}