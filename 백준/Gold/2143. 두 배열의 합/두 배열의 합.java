import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        long[] A = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        long[] B = new long[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < n; i++) A[i] = A[i - 1] + A[i];
        for(int i = 1; i < m; i++) B[i] = B[i - 1] + B[i];

        List<Long> sumA = new ArrayList<>();
        List<Long> sumB = new ArrayList<>();

        for(int i = 0; i < n; i++){
            sumA.add(A[i]);
            for(int j = 0; j < i; j++){
                sumA.add(A[i] - A[j]);
            }
        }

        for(int i = 0; i < m; i++){
            sumB.add(B[i]);
            for(int j = 0; j < i; j++){
                sumB.add(B[i] - B[j]);
            }
        }

        Collections.sort(sumA);
        Collections.sort(sumB);

        int left = 0;
        int right = sumB.size() - 1;
        long result = 0;

        while(left < sumA.size() && right >= 0){
            long curA = sumA.get(left);
            long curB = sumB.get(right);
            long sum = curA + curB;

            if(sum > T) right--;
            else if(sum < T) left++;
            else{
                long cntA = 0;
                while(left < sumA.size() && sumA.get(left) == curA){
                    left++;
                    cntA++;
                }

                long cntB = 0;
                while(right >= 0 && sumB.get(right) == curB){
                    right--;
                    cntB++;
                }

                result += cntA * cntB;
            }
        }

        System.out.println(result);
    }
}