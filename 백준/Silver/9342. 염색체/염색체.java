import java.io.*;

public class Main{
    public static final String REGEX = "([A-F]?A+F+C+[A-F]*$)";
    public static final String CORRECT_MESSAGE = "Infected!\n";
    public static final String INCORRECT_MESSAGE = "Good\n";

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++){
            String str = br.readLine();

            if(str.matches(REGEX)) sb.append(CORRECT_MESSAGE);
            else sb.append(INCORRECT_MESSAGE);
        }

        System.out.println(sb);
    }
}