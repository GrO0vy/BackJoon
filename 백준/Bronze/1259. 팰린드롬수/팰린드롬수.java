import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;

            StringBuilder sb = new StringBuilder(String.valueOf(N));
            if(sb.toString().contentEquals(sb.reverse())) result.append("yes\n");
            else result.append("no\n");
        }

        System.out.println(result);
    }
}