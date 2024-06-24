import java.io.*;
import java.util.*;

public class Main{
    static long answer;
    static int N;
    static int[] arr;
    static int[] sumArr;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        sumArr = new int[40001];
        
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){
            answer += sumArr[20000 - arr[i]];
            for(int j = 0; j < i; j++){
                sumArr[20000 + arr[i] + arr[j]]++;    
            }
        }

        System.out.println(answer);
    }
}