import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        S = S.replaceAll("0+", "0").replaceAll("1+","1");

        int one = 0;
        int zero = 0;

        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == '0') zero++;
            else one++;
        }

        if(one == 0 || zero == 0) System.out.println(0);
        else System.out.println(Math.min(one, zero));
    }
}