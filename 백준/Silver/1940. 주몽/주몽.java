import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int count = Integer.parseInt(br.readLine());
        int need = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[count];
        
        for(int i = 0; i < count; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        int startIndex = 0;
        int endIndex = count - 1;
        int sum = 0;
        int result = 0;
        
        while(startIndex < endIndex){
            sum = arr[startIndex] + arr[endIndex];
            
            if(sum == need) {
                result++;
                startIndex++;
                endIndex--;
            }
            else if(sum < need){
                startIndex++;
            }
            else{
                endIndex--;    
            }
        }
        
        System.out.println(result);
    }
}