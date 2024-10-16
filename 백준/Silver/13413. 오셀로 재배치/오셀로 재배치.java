import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++){
            int size = Integer.parseInt(br.readLine());

            String str = br.readLine();
            String target = br.readLine();

            int white = 0;
            int black = 0;

            for(int j = 0; j < size; j++){
                if(str.charAt(j) != target.charAt(j)){
                    if(str.charAt(j) == 'W') white++;
                    else black++;
                }
            }

            int cnt = Math.min(white, black) + Math.abs(white - black);
            sb.append(cnt + "\n");
        }

        System.out.println(sb);
    }
}