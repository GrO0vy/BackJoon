import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int idx = 0;
        int N = 1;

        while(true){
            String strN = String.valueOf(N);

            for(int i = 0; i < strN.length() && idx < str.length(); i++){
                if(strN.charAt(i) == str.charAt(idx)) {
                    idx++;
                }
            }

            if(idx == str.length()) break;

            N++;
        }

        System.out.println(N);
    }
}