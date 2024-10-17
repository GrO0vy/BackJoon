import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        StringBuilder sb = new StringBuilder();

        if(isPossible(N)){
            char[] arr = N.toCharArray();
            Arrays.sort(arr);

            for(int i = arr.length - 1; i >= 0; i--){
                sb.append(arr[i]);
            }
        }
        else sb.append("-1");

        System.out.println(sb);
    }

    static boolean isPossible(String N){
        if(!N.contains("0")) return false;

        int sum = 0;
        for(int i = 0; i < N.length(); i++){
            sum += N.charAt(i) - '0';
        }

        if(sum % 3 > 0) return false;

        return true;
    }
}