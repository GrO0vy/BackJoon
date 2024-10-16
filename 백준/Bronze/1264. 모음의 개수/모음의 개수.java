import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String regex = "[^aeiou|AEIOU]";
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        while(!input.equals("#")){
            input = input.replaceAll(regex, "");
            sb.append(input.length() + "\n");

            input = br.readLine();
        }

        System.out.println(sb);
    }
}