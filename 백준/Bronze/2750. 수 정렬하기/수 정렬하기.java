import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;    
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        
        for(int i = 0; i < N; i++){
            System.out.println(arr[i]);
        }
        
        br.close();
    }
}