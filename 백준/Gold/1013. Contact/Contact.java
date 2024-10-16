import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        String regex = "(100+1+|01)+";
        StringBuilder sb= new StringBuilder();

        for(int i = 0; i < T; i++){
            String str = br.readLine();
            if(str.matches(regex)) sb.append("YES");
            else sb.append("NO");
            sb.append("\n");
        }

        System.out.println(sb);
    }
}