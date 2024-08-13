import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = "";
        while(true){
            input = br.readLine();

            if(input == null || input.equals("")) break;

            int N = Integer.parseInt(input);

            sb.append(recur((int)Math.pow(3, N)) + "\n");
        }

        System.out.println(sb);
    }

    static String recur(int N){
        if(N == 1) return "-";

        return recur(N / 3) + recur(N / 3).replace("-"," ") + recur(N / 3);
    }
}