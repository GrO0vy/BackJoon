import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] arr = new boolean[2000001]; //기준점 1000000
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            arr[1000000+Integer.parseInt(br.readLine())] = true;
        }

        int len = arr.length;

        for(int i=0; i<len; i++){
            if(arr[i])
                sb.append(i-1000000).append('\n');
        }
        System.out.print(sb);
    }
}