import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()) - 1;

        String target = br.readLine();
        int cnt = 0;
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            int len = str.length();

            if(Math.abs(target.length() - str.length()) > 1) continue;

            for(int j = 0; j < target.length(); j++){
                str = str.replaceFirst(String.valueOf(target.charAt(j)), "");
            }

            if(len < target.length()){
                if(str.length() == 0) cnt++;
            }
            else{
                if(str.length() < 2) cnt++;
            }
        }

        System.out.println(cnt);
    }
}