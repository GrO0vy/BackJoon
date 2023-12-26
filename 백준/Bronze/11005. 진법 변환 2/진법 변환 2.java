import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        String result = "";
        
        while(N > 0){
            if(N % B < 10) result = (N % B) + result;
            else result = (char)(65 + (N % B - 10)) + result;
            N /= B;
        }
        
        System.out.println(result);
    }
}