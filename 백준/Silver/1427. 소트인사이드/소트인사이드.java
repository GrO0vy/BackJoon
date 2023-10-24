import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int arrSize = String.valueOf(N).length();
        int[] arr = new int[arrSize];

        for(int i = 0; i < arrSize; i++){
            arr[i] = N % 10;
            N /= 10;
        }

        for(int i = 0; i < arrSize - 1; i++){
            int max = arr[i];
            int maxIdx = i;
            for(int j = i + 1; j < arrSize; j++){
                if(arr[j] > max){
                    max = arr[j];
                    maxIdx = j;
                }
            }
            arr[maxIdx] = arr[i];
            arr[i] = max;
        }

        for(int i = 0; i < arrSize; i ++){
            sb.append(arr[i]);
        }

        System.out.println(sb);

        br.close();
    }
}