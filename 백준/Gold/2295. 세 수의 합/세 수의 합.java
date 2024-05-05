import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        int[] sumArr = new int[N * N];
        
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sumArr[i * N + j] = arr[i] + arr[j];
            }
        }
        
        Arrays.sort(arr);
        Arrays.sort(sumArr);
        
        int answer = 0;
        
        for(int i = N - 1; i >= 0; i--){
            for(int j = 0; j < i; j++){
                int gap = arr[i] - arr[j];
                
                if(isExist(gap, sumArr)) answer = Math.max(answer, arr[i]);  
            }
        }
        
        System.out.println(answer);
    }
    
    static boolean isExist(int gap, int[] sumArr){
        int start = 0;
        int end = sumArr.length - 1;
        int mid;
        
        while(start < end){
            mid = (end + start) / 2;
            
            if(sumArr[mid] == gap) return true;
            else if(gap > sumArr[mid]) start = mid + 1;
            else end = mid - 1;
        }
        
        return false;
    }
}