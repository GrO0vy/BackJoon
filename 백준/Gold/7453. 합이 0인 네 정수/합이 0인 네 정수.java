import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[4][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++){
                arr[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        int[] AB = new int[N * N];
        int[] CD = new int[N * N];

        int idx = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                AB[idx] = (arr[0][i] + arr[1][j]);
                CD[idx++] = (arr[2][i] + arr[3][j]);
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

        long answer = 0;

        int left = 0;
        int right = N*N - 1;

        while(right >= 0 && left < N * N){
            int ab = AB[left];
            int cd = CD[right];
            int number = ab + cd;

            if(number > 0){
                right--;
            }
            else if(number < 0){
                left++;
            }
            else{
                long cntAB = 0;
                long cntCD = 0;

                while(left < N * N && AB[left] == ab) {
                    left++;
                    cntAB++;
                }
                while(right >= 0 && CD[right] == cd) {
                    cntCD++;
                    right--;
                }

                answer += cntAB * cntCD;
            }
        }

        System.out.println(answer);
    }
}