import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        int divPoint = pattern.indexOf("*");
        String regex = String.format("^%s.*%s$",pattern.substring(0, divPoint), pattern.substring(divPoint + 1));

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            String fileName = br.readLine();

            if(fileName.matches(regex)){
                sb.append("DA\n");
            }
            else{
                sb.append("NE\n");
            }
        }

        System.out.println(sb);
    }
}